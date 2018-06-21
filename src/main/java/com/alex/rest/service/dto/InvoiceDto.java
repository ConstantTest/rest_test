package com.alex.rest.service.dto;

import java.math.BigDecimal;

public class InvoiceDto {

    private Long id;
    private BigDecimal amount;

    public InvoiceDto() {
    }

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
}
