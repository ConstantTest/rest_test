package com.alex.rest.service.impl;

import com.alex.rest.domen.Price;
import com.alex.rest.domen.Product;
import com.alex.rest.repository.payment.PriceRepository;
import com.alex.rest.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class PriceServiceImpl implements PriceService {

    private PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    @Transactional
    public void add(Price price) {
        priceRepository.save(price);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Price> findAll() {
        return priceRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Price findById(Long id) {
        return priceRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        priceRepository.delete(priceRepository.findById(id));
    }
}
