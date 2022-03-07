package uz.boom.ergashov.services.column;

import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.columns.ColumnCreateDto;
import uz.boom.ergashov.dto.columns.ColumnDto;
import uz.boom.ergashov.dto.columns.ColumnUpdateDto;

import uz.boom.ergashov.entity.columns.ProjectColumn;
import uz.boom.ergashov.services.GenericCrudService;


public interface    ColumnService extends GenericCrudService<
        ProjectColumn,
        ColumnDto,
        ColumnCreateDto,
        ColumnUpdateDto,
        GenericCriteria,
        Long> {
}
