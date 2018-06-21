package com.alex.rest.service.impl;

import com.alex.rest.domen.Order;
import com.alex.rest.repository.payment.OrderRepository;
import com.alex.rest.service.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ConversionService conversionService;

    @Transactional
    public OrderDto create(OrderDto orderDto) {
        Order createdOrder = orderRepository.save(conversionService.convert(orderDto, Order.class));
        return conversionService.convert(createdOrder, OrderDto.class);
    }

    @Transactional(readOnly = true)
    public Collection<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(order -> conversionService.convert(order, OrderDto.class)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        return conversionService.convert(orderRepository.findById(id), OrderDto.class);
    }

    @Transactional
    public void delete(Long id) {
        orderRepository.delete(orderRepository.findById(id));
    }
}
