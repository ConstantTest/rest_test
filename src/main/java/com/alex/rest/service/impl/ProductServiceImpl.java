package com.alex.rest.service.impl;

import com.alex.rest.domen.Product;
import com.alex.rest.repository.payment.ProductRepository;
import com.alex.rest.service.ProductService;
import com.alex.rest.service.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void add(Product product) {
        repository.save(product);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Product> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id));
    }
}
