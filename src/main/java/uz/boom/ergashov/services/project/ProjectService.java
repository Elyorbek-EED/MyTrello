package uz.boom.ergashov.services.project;

import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.project.ProjectCreateDto;
import uz.boom.ergashov.dto.project.ProjectDto;
import uz.boom.ergashov.dto.project.ProjectUpdateDto;
import uz.boom.ergashov.entity.project.Project;
import uz.boom.ergashov.services.GenericCrudService;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:33
 * Project : library_boom
 */
public interface ProjectService extends GenericCrudService<
        Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        GenericCriteria,
        Long
        > {
}
