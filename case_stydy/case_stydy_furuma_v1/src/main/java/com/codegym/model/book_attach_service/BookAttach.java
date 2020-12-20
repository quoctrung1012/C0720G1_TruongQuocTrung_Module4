package com.codegym.model.book_attach_service;

import com.codegym.entity.contract_detail.AttachService;

import java.util.ArrayList;
import java.util.List;

public class BookAttach {
    private List<BookAttachServiceItem> itemAttachList;
    private Double totalAttach;

    public BookAttach() {
        this.itemAttachList = new ArrayList<BookAttachServiceItem>();
        this.totalAttach = 0.0;
    }
    public BookAttachServiceItem getServiceItem(AttachService attachService){
        for (BookAttachServiceItem item : itemAttachList){
            if (item.getAttachService().getId() == attachService.getId()){
                return item;
            }
        }
        return null;
    }
    public List<BookAttachServiceItem> getItemAttachList(){
        return itemAttachList;
    }
    public Integer getItemAttachCount(){
        return itemAttachList.size();
    }

    public void addItemAttach(AttachService attachService, Integer quantity){
        BookAttachServiceItem bookAttachServiceItem = getServiceItem(attachService);
        if (bookAttachServiceItem !=null){
            bookAttachServiceItem.setQuantity(bookAttachServiceItem.getQuantity() + quantity);
        } else {
            bookAttachServiceItem = new BookAttachServiceItem(attachService);
            bookAttachServiceItem.setQuantity(quantity);
            itemAttachList.add(bookAttachServiceItem);
        }
    }
    private void addItemAttach(BookAttachServiceItem bookAttachServiceItem){
        addItemAttach(bookAttachServiceItem.getAttachService(), bookAttachServiceItem.getQuantity());
    }

    public void updateAttachItem(AttachService attachService, Integer quantity){
        BookAttachServiceItem bookServiceResortItem = getServiceItem(attachService);
        if (bookServiceResortItem !=null){
            bookServiceResortItem.setQuantity(quantity);
        }
    }
    public void removeAttachItem(AttachService attachService){
        BookAttachServiceItem bookServiceResortItem = getServiceItem(attachService);
        if (bookServiceResortItem !=null){
            itemAttachList.remove(bookServiceResortItem);
        }
    }
    public void clearAttachItem(){
        itemAttachList.clear();
        totalAttach = 0.0;
    }
    public boolean isEmptyAttach(){
        return itemAttachList.isEmpty();
    }
    public Double getTotalAttach(){
        totalAttach = 0.0;
        for (BookAttachServiceItem bookServiceResortItem: itemAttachList){
            totalAttach += bookServiceResortItem.getSubTotalAttach();
        }
        return totalAttach;
    }

}
