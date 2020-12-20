package com.codegym.service.service_resort.impl;

import com.codegym.entity.service.RentType;
import com.codegym.entity.service.ServiceResort;
import com.codegym.entity.service.ServiceType;
import com.codegym.repository.service.ServiceResortRepository;
import com.codegym.service.service_resort.ServiceResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceResortServiceImpl implements ServiceResortService {
    @Autowired
    private ServiceResortRepository serviceResortRepository;
    @Override
    public Iterable<ServiceResort> findByRentTypeAndServiceType(RentType rentType, ServiceType serviceType) {
        return serviceResortRepository.findByRentTypeAndServiceType(rentType, serviceType);
    }

    @Override
    public Iterable<ServiceResort> findByRentType(RentType rentType) {
        return serviceResortRepository.findByRentType(rentType);
    }

    @Override
    public Iterable<ServiceResort> findByServiceType(ServiceType serviceType) {
        return serviceResortRepository.findByServiceType(serviceType);
    }

    @Override
    public List<ServiceResort> findAll() {
        return serviceResortRepository.findAll();
    }

    @Override
    public ServiceResort findById(Long id) {
        return serviceResortRepository.findById(id).orElse(null);
    }

    @Override
    public ServiceResort save(ServiceResort serviceResort) {
        return serviceResortRepository.save(serviceResort);
    }

    @Override
    public void remove(Long id) {
        serviceResortRepository.deleteById(id);
    }

    @Override
    public Page<ServiceResort> findPageAll(Pageable pageable) {
        return serviceResortRepository.findAll(pageable);
    }

    @Override
    public Page<ServiceResort> searchByName(String string, Pageable pageable) {
        return serviceResortRepository.findByNameServiceContaining(string, pageable);
    }
}
