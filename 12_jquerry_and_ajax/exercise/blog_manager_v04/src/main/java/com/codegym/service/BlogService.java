package com.codegym.service;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    Iterable<Blog> findByCategory(Category category);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> searchBlogByTitle(String input, Pageable pageable);
}
