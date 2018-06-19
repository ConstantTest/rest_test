package com.alex.rest.service.converter;

import com.alex.rest.domen.Order;
import com.alex.rest.domen.Product;
import com.alex.rest.service.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderEntityToDtoConverter implements Converter<OrderDto, Order> {

    private ConversionService service;

    @Override
    public Order convert(OrderDto source) {
        Order order = new Order();
        order.setAmount(source.getAmount());
        List<Product> products = source.getProductDtos().stream()
        .map(productDto -> service.convert(productDto, Product.class)).collect(Collectors.toList());
        order.setProducts(products);
        return order;
    }
}
