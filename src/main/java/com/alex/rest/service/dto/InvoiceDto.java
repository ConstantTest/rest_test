package com.alex.rest.service.dto;

import java.math.BigDecimal;

public class InvoiceDto {
    private BigDecimal amount;

    public InvoiceDto() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
