package com.codegym.service.impl;

import com.codegym.model.PhoneNumber;
import com.codegym.repository.PhoneNumberRepository;
import com.codegym.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;
    @Override
    public List<PhoneNumber> findAll() {
        return phoneNumberRepository.findAll();
    }
}
