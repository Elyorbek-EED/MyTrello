package uz.boom.ergashov.services;

import uz.boom.ergashov.criteria.GenericCriteria;
import uz.boom.ergashov.dto.GenericDto;

import java.io.Serializable;
import java.util.List;


/**
 * @param <D> -> Dto
 * @param <K> -> class that defines the primary key for your pojo class
 * @param <C> -> Criteria (For Filtering Request)
 */
public interface GenericService<
        D extends GenericDto,
        C extends GenericCriteria,
        K extends Serializable> extends BaseService {

    List<D> getAll(C criteria);

    List<D> getAllById(C criteria, Long id);

    D get(K id);

    Long totalCount(C criteria);
}
