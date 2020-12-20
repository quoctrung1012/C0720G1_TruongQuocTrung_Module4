package com.codegym.service.service_resort;

import com.codegym.entity.service.RentType;
import com.codegym.entity.service.ServiceResort;
import com.codegym.entity.service.ServiceType;
import com.codegym.service.generic.ServiceGeneric;

public interface ServiceResortService extends ServiceGeneric<ServiceResort> {
    Iterable<ServiceResort> findByRentTypeAndServiceType(RentType rentType, ServiceType serviceType);
    Iterable<ServiceResort> findByRentType(RentType rentType);
    Iterable<ServiceResort> findByServiceType(ServiceType serviceType);
}
