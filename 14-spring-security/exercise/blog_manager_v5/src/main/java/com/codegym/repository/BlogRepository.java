package com.codegym.repository;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContaining(String input, Pageable pageable);
    Iterable<Blog> findByCategory(Category category);

}
