package com.codegym.service;

import com.codegym.entity.SignUp;

import java.util.List;

public interface SignUpService {
    List<SignUp> findAll();

    SignUp findById(Integer id);

    void save(SignUp signUp);

    void remove(Integer id);
}
