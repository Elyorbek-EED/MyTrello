package uz.boom.ergashov.services.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.boom.ergashov.configs.security.SessionUser;
import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.auth.AuthUserCreateDto;
import uz.boom.ergashov.dto.auth.AuthUserDto;
import uz.boom.ergashov.dto.auth.AuthUserUpdateDto;
import uz.boom.ergashov.dto.file.ResourceDto;
import uz.boom.ergashov.entity.auth.AuthUser;
import uz.boom.ergashov.entity.organization.Organization;
import uz.boom.ergashov.mapper.auth.AuthUserMapper;
import uz.boom.ergashov.reposiroty.auth.AuthUserRepository;
import uz.boom.ergashov.reposiroty.project.ProjectMemberRepository;
import uz.boom.ergashov.services.AbstractService;
import uz.boom.ergashov.services.file.FileStorageService;
import uz.boom.ergashov.utils.BaseUtils;
import uz.boom.ergashov.utils.validators.auth.AuthUserValidator;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */
@Service
public class AuthUserService extends AbstractService<AuthUserRepository, AuthUserMapper, AuthUserValidator>
        implements IAuthUserService {

    private final FileStorageService fileStorageService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    protected final ObjectMapper objectMapper;
    protected final ProjectMemberRepository projectMemberRepository;


    @Autowired
    protected AuthUserService(AuthUserRepository repository, AuthUserMapper mapper, AuthUserValidator validator, BaseUtils baseUtils, FileStorageService fileStorageService, PasswordEncoder passwordEncoder, RoleService roleService, ObjectMapper objectMapper, ProjectMemberRepository projectMemberRepository) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.objectMapper = objectMapper;
        this.projectMemberRepository = projectMemberRepository;
    }

    @Override
    public Long create(AuthUserCreateDto dto) throws IOException {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        AuthUser user = mapper.fromCreateDto(dto);

        if (Objects.nonNull(dto.getProfileImage())) {
            ResourceDto resourceDto = fileStorageService.store(dto.getProfileImage());
            user.setProfileImage("/uploads/" + resourceDto.getPath());
        }

        Long userId = repository.save(user).getId();

        String permissions = objectMapper.writeValueAsString(dto.getPermissions());
        roleService.addPermissions(userId, dto.getRole(), permissions, dto.getLanguage());

        return userId;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(AuthUserUpdateDto updateDto) throws IOException {
        return null;
    }

    @Override
    public List<AuthUserDto> getAllById(GenericCriteria criteria, Long id) {
        List<Long> userIdList = projectMemberRepository.findUserIdByProject(id);
        Organization organization = SessionUser.session().getOrganization();
        List<AuthUser> authUsers = repository.getAllByOrg(organization);

        for (Long aLong : userIdList) {
            authUsers.removeIf(authUser -> Objects.equals(authUser.getId(), aLong));
        }
        return mapper.toDto(authUsers);
    }

    @Override
    public List<AuthUserDto> getAll(GenericCriteria criteria) {
        Organization organization = SessionUser.session().getOrganization();
        List<AuthUser> authUsers = repository.getAllByOrg(organization);
        return mapper.toDto(authUsers);
    }

    @Override
    public AuthUserDto get(Long id) {
        AuthUser authUser = repository.findById((id)).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        return mapper.toDto(authUser);

    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    public void changePassword(Long sessionId, String newPassword) {
        repository.changePassword(sessionId, newPassword);
    }
}
