package com.alex.rest.service.impl;

import com.alex.rest.domen.Tenant;
import com.alex.rest.repository.payment.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class TenantServiceImpl {

    @Autowired
    private TenantRepository repository;

    @Transactional
    public void add(Tenant tenant) {
     repository.save(tenant);
    }

    @Transactional(readOnly = true)
    public Collection<Tenant> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Tenant findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(repository.findById(id));
    }
}
