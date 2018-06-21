package com.alex.rest.service.dto;


import java.math.BigDecimal;
import java.util.List;

public class OrderDto {

    private Long id;

    private BigDecimal amount;

    private List<ProductDto> products;

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

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
