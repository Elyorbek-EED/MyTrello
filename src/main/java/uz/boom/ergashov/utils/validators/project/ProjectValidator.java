package uz.boom.ergashov.utils.validators.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.boom.ergashov.dto.project.ProjectCreateDto;
import uz.boom.ergashov.dto.project.ProjectUpdateDto;
import uz.boom.ergashov.exceptions.ValidationException;
import uz.boom.ergashov.utils.BaseUtils;
import uz.boom.ergashov.utils.validators.AbstractValidator;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */
@Component
public class ProjectValidator extends AbstractValidator<ProjectCreateDto, ProjectUpdateDto,Long> {

    @Autowired
    public ProjectValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ProjectCreateDto projectCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ProjectUpdateDto cd) throws ValidationException {

    }
}
