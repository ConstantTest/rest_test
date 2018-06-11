package com.alex.rest.core;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "prices")
@NamedQueries({
        @NamedQuery(
                name = "com.alex.rest.core.Price.findAll",
        query = "SELECT p FROM Price p"),
        @NamedQuery(
                name = "com.alex.rest.core.Product.delete",
                query = "delete FROM Price p WHERE p.id = :id"
        )
})
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "currency", nullable = false)
    private String currency;

    public Price() {}

    public Price(BigDecimal price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price1 = (Price) o;
        return id == price1.id &&
                Objects.equals(price, price1.price) &&
                Objects.equals(currency, price1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, currency);
    }
}
