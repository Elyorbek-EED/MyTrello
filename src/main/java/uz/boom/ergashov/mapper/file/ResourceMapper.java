package uz.boom.ergashov.mapper.file;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.boom.ergashov.dto.file.ResourceDto;
import uz.boom.ergashov.entity.file.Resource;

/**
 * @author D4uranbek ср. 10:46. 23.02.2022
 */

@Component
@Mapper(componentModel = "spring")
public interface ResourceMapper {

    ResourceDto toDto(Resource resource);

    Resource fromDto(ResourceDto resourceDto);


}
