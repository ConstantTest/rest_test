package com.alex.rest.service.impl;

import com.alex.rest.domen.Order;
import com.alex.rest.domen.Product;
import com.alex.rest.repository.payment.ProductRepository;

import com.alex.rest.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository repository;

    @Autowired
    ConversionService conversionService;

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Transactional
    public ProductDto create(ProductDto productDto) {
        Product product = conversionService.convert(productDto, Product.class);
        repository.save(product);

        return conversionService.convert(product, ProductDto.class);
    }

    @Transactional(readOnly = true)
    public Collection<ProductDto> findAll() {
        return repository.findAll().stream()
                .map(product -> conversionService.convert(product, ProductDto.class)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {
        return conversionService.convert(repository.findById(id), ProductDto.class);
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(repository.findById(id));
    }

    @Transactional
    public ProductDto createProductForOrder(ProductDto productDto, Long orderDtoId) {
        Product createdProduct = conversionService.convert(productDto, Product.class);
        ProductDto createdProductDto = create(productDto);

        // create product to order
//        Order order = conversionService.convert(orderServiceImpl.findById(orderDtoId), Order.class);
        Order order = conversionService.convert(orderServiceImpl.findById(orderDtoId), Order.class);
        if (order != null) {
            order.addProductToOrder(createdProduct);
        }
        return createdProductDto;
    }
}
