package com.codegym.model.book_service;

import com.codegym.entity.service.ServiceResort;

public class BookServiceResortItem {
    private ServiceResort serviceResort;
    private Integer quantity;
    private Double subTotalService;

    public BookServiceResortItem(ServiceResort serviceResort) {
        this.serviceResort = serviceResort;
        this.quantity = 1;
        this.subTotalService = serviceResort.getCost();
    }

    public BookServiceResortItem() {
    }

    public ServiceResort getServiceResort() {
        return serviceResort;
    }

    public void setServiceResort(ServiceResort serviceResort) {
        this.serviceResort = serviceResort;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotalService() {
        subTotalService = serviceResort.getCost() * quantity * serviceResort.getRentType().getRenTypeCost();
        return subTotalService;
    }

    public void setSubTotalService(Double subTotalService) {
        this.subTotalService = subTotalService;
    }
}
