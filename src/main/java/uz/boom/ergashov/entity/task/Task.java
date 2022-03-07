package uz.boom.ergashov.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.boom.ergashov.entity.Auditable;
import uz.boom.ergashov.entity.columns.ProjectColumn;
import uz.boom.ergashov.entity.project.Project;

import javax.persistence.*;
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
@Entity
@Table(schema = "etm")
public class Task extends Auditable {


    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project projectId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "column_id", referencedColumnName = "id")
    private ProjectColumn columnId;

    @Column(nullable = false)
    private String name;

    private String description;

    private String level;

    private Date deadline;

    private String priority;

    private Long parentId;

    private boolean completed;

}
