package com.codegym.model.book_attach_service;

import com.codegym.entity.contract_detail.AttachService;
import com.codegym.entity.service.ServiceResort;

public class BookAttachServiceItem {
    private AttachService attachService;
    private Integer quantity;
    private Double subTotalAttach;

    public BookAttachServiceItem(AttachService attachService) {
        this.attachService = attachService;
        this.quantity = 1;
        this.subTotalAttach = attachService.getAttachCost();
    }

    public BookAttachServiceItem() {
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotalAttach() {
        subTotalAttach = attachService.getAttachCost() * quantity;
        return subTotalAttach;
    }

    public void setSubTotalAttach(Double subTotalAttach) {
        this.subTotalAttach = subTotalAttach;
    }
}
