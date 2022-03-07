package uz.boom.ergashov.services.column;

import org.springframework.stereotype.Service;
import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.columns.ColumnCreateDto;
import uz.boom.ergashov.dto.columns.ColumnDto;
import uz.boom.ergashov.dto.columns.ColumnUpdateDto;
import uz.boom.ergashov.dto.file.ResourceDto;
import uz.boom.ergashov.entity.columns.ProjectColumn;
import uz.boom.ergashov.entity.project.Project;
import uz.boom.ergashov.mapper.column.ColumnMapper;
import uz.boom.ergashov.reposiroty.colmun.ColumnRepository;
import uz.boom.ergashov.reposiroty.project.ProjectRepository;
import uz.boom.ergashov.services.AbstractService;
import uz.boom.ergashov.services.file.FileStorageService;
import uz.boom.ergashov.services.project.ProjectServiceImpl;
import uz.boom.ergashov.utils.BaseUtils;
import uz.boom.ergashov.utils.validators.column.ColumnValidator;

import java.io.IOException;
import java.util.List;
/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Service
public class ColumnServiceImpl extends AbstractService<
        ColumnRepository,
        ColumnMapper,
        ColumnValidator>
        implements ColumnService {

    private final FileStorageService fileStorageService;
    private final ProjectRepository projectRepository;

    protected ColumnServiceImpl(ColumnRepository repository,
                                ColumnMapper mapper,
                                ColumnValidator validator,
                                BaseUtils baseUtils,
                                FileStorageService fileStorageService, ProjectServiceImpl projectService, ProjectRepository projectRepository) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
        this.projectRepository = projectRepository;
    }


    @Override
    public Long create(ColumnCreateDto createDto) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(createDto.getIcon());
        ProjectColumn column = mapper.fromCreateDto(createDto);
        column.setIcon("/uploads/"+resourceDto.getPath());
        repository.save(column);
        return column.getId();
    }

    public Long createWithId(ColumnCreateDto createDto,Long projectId) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(createDto.getIcon());
        ProjectColumn column = mapper.fromCreateDto(createDto);
        column.setIcon("/uploads/"+resourceDto.getPath());
        column.setProject_id(projectRepository.getById(projectId));
        repository.save(column);
        return column.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(ColumnUpdateDto updateDto) throws IOException {
        ProjectColumn column = repository.findById(updateDto.getId()).orElseThrow(() -> {
            throw new RuntimeException("not found");
        });
        if (!updateDto.getName().equals("")) {
            column.setName(updateDto.getName());
        }

        if ( updateDto.getIcon().getSize() !=0 ) {
            ResourceDto resourceDto = fileStorageService.store(updateDto.getIcon());
            column.setIcon("/uploads/" + resourceDto.getPath());
        }
        if(updateDto.getActice()!=column.getActive()){
            column.setActive(updateDto.getActice());
        }

//        column.setPosition(updateDto.getPosition());
//        column.setActive(updateDto.getActive());
//        column.setProject_id(updateDto.getProject_id());

        repository.save(column);
        return null;
    }

    @Override
    public List<ColumnDto> getAllById(GenericCriteria criteria, Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("not found");
        });
        return mapper.toDto(repository.findAllByProject_id(project));
    }

    @Override
    public List<ColumnDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public ColumnDto get(Long id) {
        ProjectColumn column = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("not found");
        });
        return mapper.toDto(column);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }





}
