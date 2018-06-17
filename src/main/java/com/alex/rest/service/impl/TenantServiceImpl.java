package com.alex.rest.service.impl;

import com.alex.rest.domen.EntityObject;
import com.alex.rest.domen.Order;
import com.alex.rest.domen.Tenant;
import com.alex.rest.repository.payment.TenantRepository;
import com.alex.rest.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository repository;

    @Override
    @Transactional
    public void add(Tenant tenant) {
     repository.save(tenant);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Tenant> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Tenant findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(repository.findById(id));
    }
}
