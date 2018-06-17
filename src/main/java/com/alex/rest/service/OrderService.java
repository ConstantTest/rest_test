package com.alex.rest.service;

import com.alex.rest.domen.Order;

import java.util.Collection;

public interface OrderService {
    void add(Order order);
    Collection<Order> findAll(Long id);
    Order findById(Long id);
    void delete(Long id);
}
