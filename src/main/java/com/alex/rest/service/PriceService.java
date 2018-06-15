package com.alex.rest.service;

import com.alex.rest.domen.Price;

import java.util.Collection;

public interface PriceService {
    void add(Price price);
    Collection<Price> findAll();
    Price findById(Long id);
    void delete(Long id);
}
