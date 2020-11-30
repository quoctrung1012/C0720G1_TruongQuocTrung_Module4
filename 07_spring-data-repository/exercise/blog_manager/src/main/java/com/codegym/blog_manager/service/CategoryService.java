package com.codegym.blog_manager.service;

import com.codegym.blog_manager.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);

    Page<Category> findAll(Pageable pageable);

    Page<Category> findByNameCategory(String input, Pageable pageable);
}
