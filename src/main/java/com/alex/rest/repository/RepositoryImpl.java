package com.alex.rest.repository;

import com.alex.rest.domen.EntityObject;
import org.springframework.core.GenericTypeResolver;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

public abstract class RepositoryImpl<T extends EntityObject> implements Repository<T> {

    private final Class<T> currentType;
    @PersistenceContext
    private EntityManager entityManager;

    {
        TypeVariable key = Repository.class.getTypeParameters()[0];
        Class<? extends RepositoryImpl> currentClass = this.getClass();
        Type type = GenericTypeResolver.getTypeVariableMap(currentClass).get(key);
        if (!(type instanceof Class<?>)) {
            throw new IllegalStateException("Generic must be fixed. For class: " + currentClass);
        }
        @SuppressWarnings("unchecked")
        Class<T> resolvedType = (Class<T>) type;
        currentType = resolvedType;
    }

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Collection<T> findAll() {
        CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(currentType);
        query.select(query.from(currentType));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(currentType, id);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public boolean isExist(Long id) {
       return entityManager.find(currentType, id) != null;
    }
}
