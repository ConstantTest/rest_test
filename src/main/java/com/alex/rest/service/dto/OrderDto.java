package com.alex.rest.service.dto;


import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private Long id;

    private BigDecimal amount;

    private List<ProductDto> productDtos;

    public OrderDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<ProductDto> getProductDtos() {
        return productDtos;
    }

    public void setProductDtos(List<ProductDto> productDtos) {
        this.productDtos = productDtos;
    }
}
