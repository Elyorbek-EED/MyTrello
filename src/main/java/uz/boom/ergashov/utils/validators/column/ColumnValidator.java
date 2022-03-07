package uz.boom.ergashov.utils.validators.column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.boom.ergashov.dto.columns.ColumnCreateDto;
import uz.boom.ergashov.dto.columns.ColumnUpdateDto;
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
public class ColumnValidator    extends AbstractValidator<
        ColumnCreateDto,
        ColumnUpdateDto,
        Long> {

    @Autowired
    protected ColumnValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ColumnCreateDto columnCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ColumnUpdateDto cd) throws ValidationException {

    }
}
