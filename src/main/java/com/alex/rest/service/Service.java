package com.alex.rest.service;

import com.alex.rest.domen.Price;

import java.util.Collection;

public interface Service<T> {
    void add(T t);
    Collection<T> findAll();
    T findById(Long id);
    void delete(Long id);
}
