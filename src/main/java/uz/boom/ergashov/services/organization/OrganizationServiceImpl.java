package uz.boom.ergashov.services.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.file.ResourceDto;
import uz.boom.ergashov.dto.organization.OrganizationCreateDto;
import uz.boom.ergashov.dto.organization.OrganizationDto;
import uz.boom.ergashov.dto.organization.OrganizationUpdateDto;
import uz.boom.ergashov.entity.organization.Organization;
import uz.boom.ergashov.mapper.organization.OrganizationMapper;
import uz.boom.ergashov.reposiroty.organization.OrganizationRepository;
import uz.boom.ergashov.services.AbstractService;
import uz.boom.ergashov.services.file.FileStorageService;
import uz.boom.ergashov.utils.BaseUtils;
import uz.boom.ergashov.utils.validators.organization.OrganizationValidator;

import java.io.IOException;
import java.util.List;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Service
public class OrganizationServiceImpl extends AbstractService<OrganizationRepository, OrganizationMapper, OrganizationValidator>
        implements OrganizationService {

    private final FileStorageService fileStorageService;

    @Autowired
    protected OrganizationServiceImpl(OrganizationRepository repository,
                                      OrganizationMapper mapper,
                                      OrganizationValidator validator,
                                      BaseUtils baseUtils,
                                      FileStorageService fileStorageService) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Long create(OrganizationCreateDto createDto) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(createDto.getLogo());
        Organization organization = mapper.fromCreateDto(createDto);
        organization.setLogo("/uploads/" + resourceDto.getPath());
        repository.save(organization);
        return organization.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    public Void block(Long id) {
        repository.block(id);
        return null;
    }

    public Void unblock(Long id) {
        repository.unblock(id);
        return null;
    }

    @Override
    public Void update(OrganizationUpdateDto dto) throws IOException {
        ResourceDto resourceDto = fileStorageService.store(dto.getLogo());

        Organization organization = repository.findById(dto.getId()).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        mapper.fromUpdateDto(dto, organization);
        organization.setLogo("/uploads/" + resourceDto.getPath());
        repository.save(organization);
        return null;
    }

    @Override
    public List<OrganizationDto> getAllById(GenericCriteria criteria, Long id) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<OrganizationDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public OrganizationDto get(Long id) {
        Organization organization = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        return mapper.toDto(organization);
    }


    public OrganizationDto update(Long id) {
        Organization organization = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        return mapper.toDto(organization);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
