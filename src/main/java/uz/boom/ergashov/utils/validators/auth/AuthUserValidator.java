package uz.boom.ergashov.utils.validators.auth;

import org.springframework.stereotype.Component;
import uz.boom.ergashov.dto.auth.AuthUserCreateDto;
import uz.boom.ergashov.dto.auth.AuthUserUpdateDto;
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
public class AuthUserValidator extends AbstractValidator<AuthUserCreateDto, AuthUserUpdateDto, Long> {

    protected AuthUserValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(AuthUserCreateDto authUserCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(AuthUserUpdateDto cd) throws ValidationException {

    }
}
