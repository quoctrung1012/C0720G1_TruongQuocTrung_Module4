package com.codegym.service.service_resort.impl;

import com.codegym.entity.service.ServiceType;
import com.codegym.repository.service.ServiceTypeRepository;
import com.codegym.service.service_resort.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
