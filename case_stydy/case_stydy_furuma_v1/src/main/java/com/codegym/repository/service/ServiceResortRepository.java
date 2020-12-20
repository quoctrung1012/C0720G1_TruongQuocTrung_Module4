package com.codegym.repository.service;

import com.codegym.entity.service.RentType;
import com.codegym.entity.service.ServiceResort;
import com.codegym.entity.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceResortRepository extends JpaRepository<ServiceResort, Long> {
    Page<ServiceResort> findByNameServiceContaining(String string, Pageable pageable);
    Iterable<ServiceResort> findByRentTypeAndServiceType(RentType rentType, ServiceType serviceType);
    Iterable<ServiceResort> findByRentType(RentType rentType);
    Iterable<ServiceResort> findByServiceType(ServiceType serviceType);
}
