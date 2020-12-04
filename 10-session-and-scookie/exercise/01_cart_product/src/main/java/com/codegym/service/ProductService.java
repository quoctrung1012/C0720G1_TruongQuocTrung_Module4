package com.codegym.service;

import com.codegym.entity.Products;

import java.util.List;

public interface ProductService {
    Products findBySku(String sku);
    List<Products> findAll();
    void save(Products products);
    Products findById(Long id);
    void delete(Long id);
}
