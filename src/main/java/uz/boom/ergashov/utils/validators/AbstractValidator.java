package uz.boom.ergashov.utils.validators;

import uz.boom.ergashov.exceptions.ValidationException;
import uz.boom.ergashov.utils.BaseUtils;

public abstract class AbstractValidator<CD, UD, K> implements Validator {

    protected final BaseUtils baseUtils;

    protected AbstractValidator(BaseUtils baseUtils) {
        this.baseUtils = baseUtils;
    }

    public abstract void validateKey(K id) throws ValidationException;

    public abstract void validOnCreate(CD cd) throws ValidationException;

    public abstract void validOnUpdate(UD cd) throws ValidationException;


}
