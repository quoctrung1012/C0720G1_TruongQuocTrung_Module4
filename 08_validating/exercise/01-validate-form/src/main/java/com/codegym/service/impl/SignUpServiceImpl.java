package com.codegym.service.impl;

import com.codegym.entity.SignUp;
import com.codegym.repository.SignUpRepository;
import com.codegym.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private SignUpRepository signUpRepository;
    @Override
    public List<SignUp> findAll() {
        return signUpRepository.findAll();
    }

    @Override
    public SignUp findById(Integer id) {
        return signUpRepository.getOne(id);
    }

    @Override
    public void save(SignUp signUp) {
        signUpRepository.save(signUp);
    }

    @Override
    public void remove(Integer id) {
        signUpRepository.deleteById(id);
    }
}
