package com.codegym.service.__.impl;

import com.codegym.entity.__;
import com.codegym.repository.__Repository;
import com.codegym.service.__.__Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class __ServiceImpl implements __Service {
    @Autowired
    private __Repository __Repository;
    @Override
    public List<__> findAll() {
        return __Repository.findAll();
    }

    @Override
    public __ findById(Long id) {
        return __Repository.findById(id).orElse(null);
    }

    @Override
    public __ save(__ p) {
        return __Repository.save(p);
    }

    @Override
    public void remove(Long id) {
        __Repository.deleteById(id);
    }

    @Override
    public Page<__> findPageAll(Pageable pageable) {
        return __Repository.findAll(pageable);
    }

    @Override
    public Page<__> searchByName(String string, Pageable pageable) {
        return __Repository.findByNameContaining(string, pageable);
    }
}
