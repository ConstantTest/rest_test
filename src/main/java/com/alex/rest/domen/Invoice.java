package com.alex.rest.domen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "invoices")
public class Invoice extends EntityObject<Long> {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "total_amount")
    private BigDecimal amount;

    public Invoice() {}

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
