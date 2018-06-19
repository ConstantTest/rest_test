package com.alex.rest.service.impl;

import com.alex.rest.domen.PriceCategory;
import com.alex.rest.repository.payment.PriceCategoryRepository;
import com.alex.rest.service.PriceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class PriceCategoryServiceImpl implements PriceCategoryService {

    @Autowired
    private PriceCategoryRepository categoryRepository;

    @Override
    @Transactional
    public void create(PriceCategory category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<PriceCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public PriceCategory findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        categoryRepository.delete(categoryRepository.findById(id));
    }
}
