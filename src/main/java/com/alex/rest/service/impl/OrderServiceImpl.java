package com.alex.rest.service.impl;

import com.alex.rest.domen.Order;
import com.alex.rest.repository.payment.OrderRepository;
import com.alex.rest.service.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ConversionService conversionService;

    public void create(OrderDto orderDto) {
        orderRepository.save(conversionService.convert(orderDto, Order.class));
    }

    public Collection<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(order -> conversionService.convert(order, OrderDto.class)).collect(Collectors.toList());
    }

    public OrderDto findById(Long id) {
        return conversionService.convert(orderRepository.findById(id), OrderDto.class);
    }

    public void delete(Long id) {
        orderRepository.delete(orderRepository.findById(id));
    }
}
