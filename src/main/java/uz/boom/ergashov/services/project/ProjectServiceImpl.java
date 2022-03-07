package uz.boom.ergashov.services.project;

import org.springframework.stereotype.Service;
import uz.boom.ergashov.configs.security.SessionUser;
import uz.boom.ergashov.configs.security.UserDetails;
import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.file.ResourceDto;
import uz.boom.ergashov.dto.project.ProjectCreateDto;
import uz.boom.ergashov.dto.project.ProjectDto;
import uz.boom.ergashov.dto.project.ProjectUpdateDto;
import uz.boom.ergashov.entity.organization.Organization;
import uz.boom.ergashov.entity.project.Project;
import uz.boom.ergashov.mapper.project.ProjectMapper;
import uz.boom.ergashov.reposiroty.organization.OrganizationRepository;
import uz.boom.ergashov.reposiroty.project.ProjectMemberRepository;
import uz.boom.ergashov.reposiroty.project.ProjectRepository;
import uz.boom.ergashov.services.AbstractService;
import uz.boom.ergashov.services.file.FileStorageService;
import uz.boom.ergashov.utils.BaseUtils;
import uz.boom.ergashov.utils.validators.project.ProjectValidator;

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
public class ProjectServiceImpl extends AbstractService<ProjectRepository, ProjectMapper, ProjectValidator>
        implements ProjectService {

    private final FileStorageService fileStorageService;
    private final OrganizationRepository organizationRepository;
    private final ProjectMemberRepository projectMemberRepository;

    public ProjectServiceImpl(ProjectRepository repository, ProjectMapper mapper, ProjectValidator validator, BaseUtils baseUtils, FileStorageService fileStorageService, ProjectMemberRepository projectMemberRepository, OrganizationRepository organizationRepository, ProjectMemberRepository projectMemberRepository1) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
        this.organizationRepository = organizationRepository;
        this.projectMemberRepository = projectMemberRepository1;
    }


    @Override
    public Long create(ProjectCreateDto createDto) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(createDto.getTz());
        Project project = mapper.fromCreateDto(createDto);
        project.setClosed(false);
        project.setOrganization(SessionUser.session().getOrganization());
        project.setTzPath("/uploads/" + resourceDto.getPath());
        repository.save(project);
        return project.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(ProjectUpdateDto dto) throws IOException {
        Project project = repository.findById(dto.getId()).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        if (!dto.getName().equals(""))
            project.setName(dto.getName());

        if (dto.getTzFile().getSize()!=0) {
            ResourceDto resourceDto = fileStorageService.store(dto.getTzFile());
            project.setTzPath("/uploads/" + resourceDto.getPath());
        }
        if(Objects.isNull(dto.getClosed())){
         project.setClosed(false);
        }else {
            project.setClosed(true);
        }
        repository.save(project);
        return null;
    }

    @Override
    public List<ProjectDto> getAllById(GenericCriteria criteria, Long id) {
        List<Long> projectIdList = projectMemberRepository.findProjectIdByUser(id);
        Organization organization=SessionUser.session().getOrganization();
        List<Project> projects=repository.findAllByOrganization_id(organization);

        for (Long aLong : projectIdList) {
            projects.removeIf(project -> Objects.equals(project.getId(),aLong));
        }
        return mapper.toDto(projects);
    }

    @Override
    public List<ProjectDto> getAll(GenericCriteria criteria) {
        UserDetails session = SessionUser.session();
        Long orgId = session.getOrganization().getId();
        Organization organization = organizationRepository.findById(orgId).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        return mapper.toDto(repository.findAllByOrganization_id(organization));
    }

    @Override
    public ProjectDto get(Long id) {
        Project project = repository.findById((id)).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        return mapper.toDto(project);
    }


    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

}
