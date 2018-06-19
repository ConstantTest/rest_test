package com.alex.rest.service.impl;

import com.alex.rest.domen.Invoice;
import com.alex.rest.repository.payment.InvoiceRepository;
import com.alex.rest.service.dto.InvoiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    ConversionService conversionService;

    public void create(InvoiceDto invoiceDto) {
        invoiceRepository.save(conversionService.convert(invoiceDto, Invoice.class));
    }

    @Transactional(readOnly = true)
    public Collection<InvoiceDto> findAll() {
        return invoiceRepository.findAll().stream()
                .map(invoice -> conversionService.convert(invoice, InvoiceDto.class)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Invoice findById(Long id) {
        return conversionService.convert(invoiceRepository.findById(id), Invoice.class);
    }


    @Transactional
    public void delete(Long id) {
        invoiceRepository.delete(invoiceRepository.findById(id));
    }
}
