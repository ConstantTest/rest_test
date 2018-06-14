package com.alex.rest.domen;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "prices")
public class Price extends EntityObject<Long> {

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "product_id")
    private Long productId;

//    @OneToOne
//    private Product product;

    public Price() {}

    public Price(BigDecimal price, String currency, Long productId) {
        this.price = price;
        this.currency = currency;
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

//     public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
}
