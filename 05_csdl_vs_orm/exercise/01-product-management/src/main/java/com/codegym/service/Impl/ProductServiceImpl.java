package com.codegym.service.Impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
//    private static Map<Integer, Product> productMap;
//
//    static {
//        productMap = new TreeMap<>();
//        productMap.put(1, new Product(1, "SamSung S4", "SamSung", 350.5, 20, "N/A"));
//        productMap.put(2, new Product(2, "SamSung S5", "SamSung", 450.5, 20, "N/A"));
//        productMap.put(3, new Product(3, "SamSung S6", "SamSung", 550.5, 20, "N/A"));
//        productMap.put(4, new Product(4, "SamSung S7", "SamSung", 650.5, 20, "N/A"));
//        productMap.put(5, new Product(5, "SamSung S8", "SamSung", 850.5, 20, "N/A"));
//        productMap.put(6, new Product(6, "SamSung S9", "SamSung", 950.5, 20, "N/A"));
//        productMap.put(7, new Product(7, "SamSung S10", "SamSung", 1050.5, 20, "N/A"));
//        productMap.put(8, new Product(8, "SamSung S20", "SamSung", 1250.5, 20, "N/A"));
//    }

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        this.productRepository.update(id, product);
    }

    @Override
    public void delete(Integer id) {
        this.productRepository.delete(id);
    }
}