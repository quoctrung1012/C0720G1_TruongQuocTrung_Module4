package com.codegym.repository;

import com.codegym.entity.__;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface __Repository extends JpaRepository<__, Long> {
    Page<__> findByNameContaining(String input, Pageable pageable);
}
