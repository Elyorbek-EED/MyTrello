package uz.boom.ergashov.utils.validators.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.boom.ergashov.dto.organization.OrganizationCreateDto;
import uz.boom.ergashov.dto.organization.OrganizationUpdateDto;
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
public class OrganizationValidator extends AbstractValidator<OrganizationCreateDto, OrganizationUpdateDto, Long> {


    @Autowired
    protected OrganizationValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(OrganizationCreateDto organizationCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(OrganizationUpdateDto cd) throws ValidationException {

    }
}
