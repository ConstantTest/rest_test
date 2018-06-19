package com.alex.rest.service.converter;

import com.alex.rest.domen.Product;
import com.alex.rest.service.dto.ProductDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


@Component
public class ProductDtoToEntityConverter implements Converter<ProductDto, Product> {

    @Override
    public Product convert(@NonNull ProductDto source) {
        Product product = new Product();
        product.setProductName(source.getProductName());
        return product;
    }
}
