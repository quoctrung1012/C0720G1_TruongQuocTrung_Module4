package com.codegym.repository;

import com.codegym.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
    Products findBySku(String sku);
}
