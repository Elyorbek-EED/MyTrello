package uz.boom.ergashov.dto.comment;

import lombok.*;
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


public class CommentDto extends GenericDto {
    private Task taskId;
    /*private CommentType commentType;*/
    private String commentText;


    @Builder(builderMethodName = "childBuilder")
    public CommentDto(Long id, Task taskId, String commentText) {
        super(id);
        this.taskId = taskId;
        this.commentText = commentText;
    }


}
