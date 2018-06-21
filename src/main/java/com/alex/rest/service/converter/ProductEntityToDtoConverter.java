package com.alex.rest.service.converter;

import com.alex.rest.domen.Product;
import com.alex.rest.service.dto.ProductDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


@Component
public class ProductEntityToDtoConverter implements Converter<Product, ProductDto> {

    @Override
    public ProductDto convert(@NonNull Product source) {
        ProductDto productDto = new ProductDto();
        productDto.setId(source.getId());
        productDto.setProductName(source.getProductName());
        return productDto;
    }
}
