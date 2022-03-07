package uz.boom.ergashov.mapper.column;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.boom.ergashov.dto.columns.ColumnCreateDto;
import uz.boom.ergashov.dto.columns.ColumnDto;
import uz.boom.ergashov.dto.columns.ColumnUpdateDto;
import uz.boom.ergashov.entity.columns.ProjectColumn;
import uz.boom.ergashov.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ColumnMapper extends BaseMapper<
        ProjectColumn,
        ColumnDto,
        ColumnCreateDto,
        ColumnUpdateDto> {

    @Override
    ColumnDto toDto(ProjectColumn projectColumn);

    @Override
    List<ColumnDto> toDto(List<ProjectColumn> e);

    @Override
    @Mapping(target = "icon", ignore = true)
    ProjectColumn fromUpdateDto(ColumnUpdateDto dto);

    @Override
    @Mapping(target = "icon", ignore = true)
    ProjectColumn fromCreateDto(ColumnCreateDto columnCreateDto);

    @Mapping(target = "icon", ignore = true)
    ProjectColumn fromUpdateDto(ColumnUpdateDto columnUpdateDto, @MappingTarget ProjectColumn column);
}
