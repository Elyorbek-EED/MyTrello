package uz.boom.ergashov.services.comment;

import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.comment.CommentDto;
import uz.boom.ergashov.dto.comment.CreateCommentDto;
import uz.boom.ergashov.dto.comment.UpdateCommentDto;
import uz.boom.ergashov.entity.comment.Comment;
import uz.boom.ergashov.services.GenericCrudService;

public interface CommentService extends GenericCrudService<
        Comment,
        CommentDto,
        CreateCommentDto,
        UpdateCommentDto,
        GenericCriteria,
        Long> {
}
