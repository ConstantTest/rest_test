package com.alex.rest.domen;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Table(name = "prices")
public class Price extends EntityObject<Long> {

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false)
    private Currency currency;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "product_id")
    private Product product;

    public Price() {}

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal price) {
        this.amount = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
