package com.codegym.blog_manager.service.impl;

import com.codegym.blog_manager.entity.Blog;
import com.codegym.blog_manager.entity.Category;
import com.codegym.blog_manager.repository.BlogRepository;
import com.codegym.blog_manager.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Iterable<Blog> findByCategory(Category category) {
        return blogRepository.findByCategory(category);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> searchBlogByTitle(String input, Pageable pageable) {
        return blogRepository.findByTitleContaining(input, pageable);
    }

}
