package com.alex.rest.service.converter;

import com.alex.rest.domen.Invoice;
import com.alex.rest.service.dto.InvoiceDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class InvoiceDtoToEntityConverter implements Converter<InvoiceDto, Invoice> {

    @Override
    public Invoice convert(@NonNull InvoiceDto dto) {
        Invoice invoice = new Invoice();
        invoice.setAmount(dto.getAmount());
        return invoice;
    }
}
