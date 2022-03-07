package uz.boom.ergashov.mapper.organization;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.boom.ergashov.dto.organization.OrganizationCreateDto;
import uz.boom.ergashov.dto.organization.OrganizationDto;
import uz.boom.ergashov.dto.organization.OrganizationUpdateDto;
import uz.boom.ergashov.entity.organization.Organization;
import uz.boom.ergashov.mapper.BaseMapper;


@Component
@Mapper(componentModel = "spring")
public interface    OrganizationMapper extends BaseMapper<
        Organization,
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto> {


    @Override
    @Mapping(target = "logo", ignore = true)
    Organization fromCreateDto(OrganizationCreateDto organizationCreateDto);

    @Override
    @Mapping(target = "logo", ignore = true)
    Organization fromUpdateDto(OrganizationUpdateDto organizationUpdateDto);

    @Mapping(target = "logo", ignore = true)
    Organization fromUpdateDto(OrganizationUpdateDto organizationUpdateDto, @MappingTarget Organization organization);
}
