package com.alex.rest.service.converter;

import com.alex.rest.domen.Invoice;
import com.alex.rest.service.dto.InvoiceDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


@Component
public class InvoiceEntityToDtoConverter implements Converter<Invoice, InvoiceDto> {

    @Override
    public InvoiceDto convert(@NonNull Invoice source) {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setAmount(source.getAmount());
        return invoiceDto;
    }
}
