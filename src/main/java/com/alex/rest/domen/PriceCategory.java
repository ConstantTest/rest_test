package com.alex.rest.domen;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "pricecategories")
public class PriceCategory extends EntityObject<Long> {

    @Column(name = "type", nullable = false)
    private String type;

    public PriceCategory() {}

    @OneToOne
    @JoinColumn(name = "price_id")
    @Ignore
    private Price price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
