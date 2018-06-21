package com.alex.rest.repository;

import com.alex.rest.domen.EntityObject;

import java.util.Collection;


public interface Repository<T extends EntityObject> {
    T save(T entity);

    Collection<T> findAll();

    T findById(Long id);

    void delete(T entity);

    boolean isExist(Long id);
}
