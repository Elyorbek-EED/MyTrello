package uz.boom.ergashov.dto.comment;

import lombok.*;
import uz.boom.ergashov.dto.Dto;
import uz.boom.ergashov.entity.task.Task;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreateCommentDto implements Dto {
    private Task taskId;
    /*private CommentType commentType;*/
    private String commentText;
}
