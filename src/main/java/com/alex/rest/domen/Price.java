package com.alex.rest.domen;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.List;

@Entity
@Table(name = "prices")
public class Price extends EntityObject<Long> {

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false)
    private Currency currency;

    public Price() {}

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "price", cascade = CascadeType.ALL)
    private Collection<PriceCategory> priceCategories = new ArrayList<>();

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

    public Collection<PriceCategory> getPriceCategories() {
        return priceCategories;
    }

    public void setPriceCategories(Collection<PriceCategory> priceCategories) {
        this.priceCategories = priceCategories;
    }
}
