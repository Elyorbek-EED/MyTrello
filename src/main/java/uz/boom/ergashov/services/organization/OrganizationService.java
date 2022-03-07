package uz.boom.ergashov.services.organization;


import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.organization.OrganizationCreateDto;
import uz.boom.ergashov.dto.organization.OrganizationDto;
import uz.boom.ergashov.dto.organization.OrganizationUpdateDto;
import uz.boom.ergashov.entity.organization.Organization;
import uz.boom.ergashov.services.GenericCrudService;


public interface OrganizationService extends GenericCrudService<
        Organization,
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto,
        GenericCriteria,
        Long> {


}
