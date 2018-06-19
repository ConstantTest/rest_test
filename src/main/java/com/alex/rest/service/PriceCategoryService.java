package com.alex.rest.service;

import com.alex.rest.domen.Price;
import com.alex.rest.domen.PriceCategory;

import java.util.Collection;

public interface PriceCategoryService {

    void create(PriceCategory category);
    Collection<PriceCategory> findAll();
    PriceCategory findById(Long id);
    void delete(Long id);
}
