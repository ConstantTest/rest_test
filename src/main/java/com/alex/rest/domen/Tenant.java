package com.alex.rest.domen;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tenants")
public class Tenant extends EntityObject<Long> {

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Price> prices = new ArrayList<>();

    public Tenant() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
