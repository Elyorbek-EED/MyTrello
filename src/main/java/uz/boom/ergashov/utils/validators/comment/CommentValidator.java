package uz.boom.ergashov.utils.validators.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.boom.ergashov.dto.comment.CreateCommentDto;
import uz.boom.ergashov.dto.comment.UpdateCommentDto;
import uz.boom.ergashov.exceptions.ValidationException;
import uz.boom.ergashov.utils.BaseUtils;
import uz.boom.ergashov.utils.validators.AbstractValidator;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Component

public class CommentValidator extends AbstractValidator<CreateCommentDto, UpdateCommentDto,Long> {

    @Autowired
    public CommentValidator(BaseUtils utils){
        super(utils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CreateCommentDto dto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(UpdateCommentDto cd) throws ValidationException {

    }
}
