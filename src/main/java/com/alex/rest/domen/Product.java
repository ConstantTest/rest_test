package com.alex.rest.domen;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends EntityObject<Long> {

    @Column(name = "productName", nullable = false)
    private String productName;

//    @OneToOne(mappedBy="product")
    @Transient
    private Price price;

    public Product() {}

    public Product(String productName) {
        this.productName = productName;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}