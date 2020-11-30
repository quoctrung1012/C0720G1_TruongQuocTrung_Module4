package com.codegym.blog_manager.repository;

import com.codegym.blog_manager.entity.Blog;
import com.codegym.blog_manager.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContaining(String input, Pageable pageable);
    Iterable<Blog> findByCategory(Category category);

}
