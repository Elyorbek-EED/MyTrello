package uz.boom.ergashov.entity.comment;

import lombok.Getter;
import lombok.Setter;
import uz.boom.ergashov.entity.Auditable;
import uz.boom.ergashov.entity.task.Task;

import javax.persistence.*;

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
@Table(name = "comments")

public class Comment extends Auditable {

    @ManyToOne
//    @Column(name = "task_id",nullable = false)
    @JoinColumn(name = "task_id",referencedColumnName = "id")
    private  Task taskId;

   /* @OneToOne
    @Column(name = "comment_type",nullable = false)
    private CommentType commentType;*/

    @Column
    private String commentText;

}
