package uz.boom.ergashov.services.task;

import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.task.TaskCreateDto;
import uz.boom.ergashov.dto.task.TaskDto;
import uz.boom.ergashov.dto.task.TaskUpdateDto;
import uz.boom.ergashov.entity.task.Task;
import uz.boom.ergashov.services.GenericCrudService;

public interface TaskService extends GenericCrudService<Task, TaskDto, TaskCreateDto, TaskUpdateDto, GenericCriteria, Long> {
}
