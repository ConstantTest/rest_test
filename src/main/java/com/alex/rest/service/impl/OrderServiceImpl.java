package com.alex.rest.service.impl;

import com.alex.rest.domen.Order;
import com.alex.rest.repository.payment.OrderRepository;
import com.alex.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    @Transactional
    public void add(Order order) {
        repository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Order> findAll(Long id) {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(repository.findById(id));
    }
}
