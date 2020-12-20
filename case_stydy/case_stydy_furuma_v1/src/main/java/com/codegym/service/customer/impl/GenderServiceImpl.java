package com.codegym.service.customer.impl;

import com.codegym.entity.customer.GenderPerson;
import com.codegym.repository.customer.GenderRepository;
import com.codegym.service.customer.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderRepository genderRepository;
    @Override
    public List<GenderPerson> findAll() {
        return genderRepository.findAll();
    }
}
