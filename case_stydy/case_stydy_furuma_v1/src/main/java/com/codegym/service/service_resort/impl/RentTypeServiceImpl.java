package com.codegym.service.service_resort.impl;

import com.codegym.entity.service.RentType;
import com.codegym.repository.service.RentTypeRepository;
import com.codegym.service.service_resort.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeServiceImpl implements RentTypeService {

    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
