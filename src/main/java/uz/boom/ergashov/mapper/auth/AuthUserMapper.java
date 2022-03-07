package uz.boom.ergashov.mapper.auth;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.boom.ergashov.dto.auth.AuthUserCreateDto;
import uz.boom.ergashov.dto.auth.AuthUserDto;
import uz.boom.ergashov.dto.auth.AuthUserUpdateDto;
import uz.boom.ergashov.entity.auth.AuthUser;
import uz.boom.ergashov.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<
        AuthUser,
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto> {

    @Override
    @Mapping(target = "profileImage", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "language", ignore = true)
    AuthUser fromCreateDto(AuthUserCreateDto dto);

    @Override
    @Mapping(target = "profileImage", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "language", ignore = true)
    AuthUser fromUpdateDto(AuthUserUpdateDto dto);

    @Override
    @Mapping(target = "profileImage", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "language", ignore = true)
    AuthUserDto toDto(AuthUser authUser);

    @Override
    @Mapping(target = "profileImage", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "language", ignore = true)
    List<AuthUserDto> toDto(List<AuthUser> e);

    @Mapping(target = "profileImage", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "language", ignore = true)
    AuthUser fromUpdateDto(AuthUserUpdateDto dto, @MappingTarget AuthUser authUser);
}
