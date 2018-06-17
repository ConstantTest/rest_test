package com.alex.rest.service;

import com.alex.rest.domen.Product;

import java.util.Collection;

public interface ProductService {
    void add(Product product);
    Collection<Product> findAll(Long id);
    Product findById(Long id);
    void delete(Long id);
}
