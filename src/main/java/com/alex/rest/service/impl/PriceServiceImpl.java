package com.alex.rest.service.impl;

import com.alex.rest.domen.Price;
import com.alex.rest.repository.payment.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class PriceServiceImpl {

    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private PriceServiceImpl priceService;

    @Transactional
    public void add(Price price) {
        priceRepository.save(price);
    }

    @Transactional(readOnly = true)
    public Collection<Price> findAll(Long id) {
        return priceRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Price findById(Long id) {
        return priceRepository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        priceRepository.delete(priceRepository.findById(id));
    }
}
