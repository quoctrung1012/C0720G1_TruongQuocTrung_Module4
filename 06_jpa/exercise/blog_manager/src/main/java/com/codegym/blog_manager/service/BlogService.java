package com.codegym.blog_manager.service;

import com.codegym.blog_manager.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    List<Blog> findByName();
}
