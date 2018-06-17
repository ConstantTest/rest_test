package com.alex.rest.service;

import com.alex.rest.domen.EntityObject;
import com.alex.rest.domen.Order;
import com.alex.rest.domen.Price;
import com.alex.rest.domen.Tenant;

import java.util.Collection;

public interface TenantService {
    void add(Tenant tenant);
    Collection<Tenant> findAll();
    Tenant findById(Long id);
    void delete(Long id);
}
