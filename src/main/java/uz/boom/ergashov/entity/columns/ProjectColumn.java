package uz.boom.ergashov.entity.columns;

import lombok.Getter;
import lombok.Setter;
import uz.boom.ergashov.entity.Auditable;
import uz.boom.ergashov.entity.project.Project;

import javax.persistence.*;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Entity
@Getter
@Setter
@Table(name = "column" , schema = "etm")
public class ProjectColumn extends Auditable {

    @Column(name = "name",nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project_id;

    @Column(name = "position")
    private int position;

    @Column(name = "icon")
    private String  icon;

    @Column(name = "active")
    private Boolean active;
}
