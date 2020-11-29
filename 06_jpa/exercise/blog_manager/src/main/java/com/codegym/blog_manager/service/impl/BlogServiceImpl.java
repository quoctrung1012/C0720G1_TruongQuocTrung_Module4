package com.codegym.blog_manager.service.impl;

import com.codegym.blog_manager.entity.Blog;
import com.codegym.blog_manager.repository.BlogRepository;
import com.codegym.blog_manager.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.getOne(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByName() {
        return null;
    }

}
