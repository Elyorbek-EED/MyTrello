package uz.boom.ergashov.services.auth;


import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.auth.AuthUserCreateDto;
import uz.boom.ergashov.dto.auth.AuthUserDto;
import uz.boom.ergashov.dto.auth.AuthUserUpdateDto;
import uz.boom.ergashov.entity.auth.AuthUser;
import uz.boom.ergashov.services.GenericCrudService;

/**
 * @author D4uranbek вс. 15:02. 20.02.2022
 */
public interface IAuthUserService extends GenericCrudService<
        AuthUser,
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto,
        GenericCriteria,
        Long> {
}
