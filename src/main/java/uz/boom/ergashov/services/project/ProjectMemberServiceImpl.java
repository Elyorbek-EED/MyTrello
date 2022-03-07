package uz.boom.ergashov.services.project;

import org.springframework.stereotype.Service;
import uz.boom.ergashov.dto.auth.AuthUserDto;
import uz.boom.ergashov.entity.auth.AuthUser;
import uz.boom.ergashov.entity.project.ProjectMember;
import uz.boom.ergashov.mapper.auth.AuthUserMapper;
import uz.boom.ergashov.mapper.project.ProjectMemberMapper;
import uz.boom.ergashov.reposiroty.auth.AuthUserRepository;
import uz.boom.ergashov.reposiroty.project.ProjectMemberRepository;
import uz.boom.ergashov.reposiroty.project.ProjectRepository;
import uz.boom.ergashov.services.AbstractService;
import uz.boom.ergashov.utils.BaseUtils;
import uz.boom.ergashov.utils.validators.project.ProjectValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Service
public class ProjectMemberServiceImpl extends AbstractService<ProjectMemberRepository, ProjectMemberMapper, ProjectValidator>
{

    private final AuthUserRepository authUserRepository;
    private final AuthUserMapper authUserMapper;
    private final ProjectRepository projectRepository;

    public ProjectMemberServiceImpl(ProjectMemberRepository repository, ProjectMemberMapper mapper, ProjectValidator validator, BaseUtils baseUtils, AuthUserRepository authUserRepository, AuthUserMapper authUserMapper, ProjectRepository projectRepository) {
        super(repository, mapper, validator, baseUtils);
        this.authUserRepository = authUserRepository;
        this.authUserMapper = authUserMapper;
        this.projectRepository = projectRepository;
    }

    public List<AuthUserDto> getMembers(Long id) {
        List<ProjectMember> projectMembers = repository.findAllByProject(id);
        List<AuthUser> authUsers=new ArrayList<>();
        for (ProjectMember projectMember : projectMembers) {
            authUsers.add(projectMember.getAuthUser());
        }
        return authUserMapper.toDto(authUsers);
    }

    public void delete(Long id) {
        AuthUser authUser = authUserRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        repository.deleteByAuthUser(authUser);
    }

    public void addUser(Long id, List<Long> userIdList) {
        for (Long aLong : userIdList) {
            repository.insertMember(id,aLong);
        }
    }
}
