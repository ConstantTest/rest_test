package com.alex.rest.service.dto;

public class ProductDto {

    private String productName;

    private Long id;

    public ProductDto() {}

    public String getProductName() {
        return productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
