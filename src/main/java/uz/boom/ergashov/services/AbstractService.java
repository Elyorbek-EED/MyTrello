package uz.boom.ergashov.services;

import uz.boom.ergashov.mapper.Mapper;
import uz.boom.ergashov.reposiroty.AbstractRepository;
import uz.boom.ergashov.utils.BaseUtils;
import uz.boom.ergashov.utils.validators.Validator;

/**
 * @param <R> repository
 * @param <M>
 * @param <V>
 */
public abstract class AbstractService<
        R extends AbstractRepository,
        M extends Mapper,
        V extends Validator> {
    protected final R repository;
    protected final M mapper;
    protected final V validator;
    protected final BaseUtils baseUtils;


    protected AbstractService(R repository, M mapper, V validator, BaseUtils baseUtils) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
        this.baseUtils = baseUtils;
    }
}
