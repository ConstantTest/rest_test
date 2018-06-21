package com.alex.rest.service.converter;

import com.alex.rest.domen.Order;
import com.alex.rest.service.dto.OrderDto;
import com.alex.rest.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderEntityToDtoConverter implements Converter<Order, OrderDto> {

    private ConversionService conversionService;

    @Autowired
    public OrderEntityToDtoConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public OrderDto convert(@NonNull Order source) {
        OrderDto orderDto = new OrderDto();
        orderDto.setAmount(source.getAmount());
        orderDto.setId(source.getId());
        List<ProductDto> dtoProducts = source.getProducts().stream()
                .map(product -> conversionService.convert(product, ProductDto.class)).collect(Collectors.toList());
        orderDto.setProducts(dtoProducts);
        return orderDto;
    }
}
