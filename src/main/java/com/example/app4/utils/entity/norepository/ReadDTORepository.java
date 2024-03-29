package com.example.app4.utils.entity.norepository;

import com.example.app4.utils.exceptions.NoRollbackException;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoRepositoryBean
@Transactional(readOnly = true,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,noRollbackFor = {NoRollbackException.class})
public interface ReadDTORepository<BaseDTO extends AbstractDTO,Entity, ID> extends Repository<Entity, ID> {

     <R extends BaseDTO> List<R> findAllBy(Class<R> clazz);

     <R extends BaseDTO> R findById(ID id, Class<R> clazz);

     <R extends BaseDTO> List<R> findByIdIn(Iterable<ID> ids, Class<R> clazz);

     <R extends BaseDTO> List<R> findByIdIn(ID[] ids, Class<R> clazz);

}