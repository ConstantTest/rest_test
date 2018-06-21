package com.alex.rest.service.impl;

import com.alex.rest.domen.Invoice;
import com.alex.rest.repository.SearchCriteria;
import com.alex.rest.repository.payment.InvoiceRepository;
import com.alex.rest.service.dto.InvoiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    ConversionService conversionService;

    @Transactional
    public InvoiceDto create(InvoiceDto invoiceDto) {
        Invoice createdInvoice = invoiceRepository.save(conversionService.convert(invoiceDto, Invoice.class));
        return conversionService.convert(createdInvoice, InvoiceDto.class);
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

    @Transactional(readOnly = true)
    public List<InvoiceDto> searchInvoice(List<SearchCriteria> params) {
        params.add(new SearchCriteria("id", ":", "2"));
        params.add(new SearchCriteria("amount", ":", "100.00"));
        return invoiceRepository.searchInvoice(params).stream()
                .map(invoice -> conversionService.convert(invoice, InvoiceDto.class)).collect(Collectors.toList());
    }
}
