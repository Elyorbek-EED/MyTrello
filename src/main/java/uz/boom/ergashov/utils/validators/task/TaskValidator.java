package uz.boom.ergashov.utils.validators.task;

import org.springframework.stereotype.Component;
import uz.boom.ergashov.dto.task.TaskCreateDto;
import uz.boom.ergashov.dto.task.TaskUpdateDto;
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
public class TaskValidator extends AbstractValidator<TaskCreateDto, TaskUpdateDto, Long> {
    protected TaskValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(TaskCreateDto taskCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(TaskUpdateDto cd) throws ValidationException {

    }
}
