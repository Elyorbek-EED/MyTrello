package uz.boom.ergashov.dto.comment;

import lombok.Getter;
import lombok.Setter;
import uz.boom.ergashov.dto.GenericDto;
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


public class UpdateCommentDto extends GenericDto {
    private Task taskId;
    /*private CommentType commentType;*/
    private String commentText;
}
