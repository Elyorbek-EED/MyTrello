package uz.boom.ergashov.dto.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.ergashov.dto.Dto;
import uz.boom.ergashov.entity.columns.ProjectColumn;
import uz.boom.ergashov.entity.project.Project;

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
@AllArgsConstructor
@Builder
public class TaskCreateDto implements Dto {
    private Project projectId;
    private ProjectColumn columnId;
    private String name;
    private String description;
    private String level;
    private String priority;
    private Date deadline;
}