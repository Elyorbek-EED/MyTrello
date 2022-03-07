package uz.boom.ergashov.dto.task;

import lombok.Getter;
import lombok.Setter;
import uz.boom.ergashov.dto.GenericDto;

import java.util.Date;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Getter
@Setter
public class TaskUpdateDto extends GenericDto {
    private String name;
    private String description;
    private String level;
    private Date deadline;
    private String priority;

    public TaskUpdateDto(Long id, String name, String description, String level, Date deadline, String priority) {
        super(id);
        this.name = name;
        this.description = description;
        this.level = level;
        this.deadline = deadline;
        this.priority = priority;
    }
}
