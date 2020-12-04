package com.codegym.service.impl;

import com.codegym.entity.Products;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Products findBySku(String sku) {
        return null;
    }

    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Products products) {
        productRepository.save(products);
    }

    @Override
    public Products findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
