package com.codegym.model.book_service;

import com.codegym.entity.service.ServiceResort;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<BookServiceResortItem> itemServiceList;
    private Double totalService;

    public BookService() {
        this.itemServiceList = new ArrayList<BookServiceResortItem>();
        this.totalService = 0.0;
    }
    public BookServiceResortItem getServiceItem(ServiceResort serviceResort){
        for (BookServiceResortItem item : itemServiceList){
            if (item.getServiceResort().getId() == serviceResort.getId()){
                return item;
            }
        }
        return null;
    }
    public List<BookServiceResortItem> getItemServiceList(){
        return itemServiceList;
    }
    public Integer getItemServiceCount(){
        return itemServiceList.size();
    }
    private void addItemService(BookServiceResortItem bookServiceResortItem){
        addItemService(bookServiceResortItem.getServiceResort(), bookServiceResortItem.getQuantity());
    }
    public void addItemService(ServiceResort serviceResort, Integer quantity){
        BookServiceResortItem bookServiceResortItem = getServiceItem(serviceResort);
        if (bookServiceResortItem !=null){
            bookServiceResortItem.setQuantity(bookServiceResortItem.getQuantity() + quantity);
        } else {
            bookServiceResortItem = new BookServiceResortItem(serviceResort);
            bookServiceResortItem.setQuantity(quantity);
            itemServiceList.add(bookServiceResortItem);
        }

    }
    public void updateServiceItem(ServiceResort serviceResort, Integer quantity){
        BookServiceResortItem bookServiceResortItem = getServiceItem(serviceResort);
        if (bookServiceResortItem !=null){
            bookServiceResortItem.setQuantity(quantity);
        }
    }
    public void removeServiceItem(ServiceResort serviceResort){
        BookServiceResortItem bookServiceResortItem = getServiceItem(serviceResort);
        if (bookServiceResortItem !=null){
            itemServiceList.remove(bookServiceResortItem);
        }
    }
    public void clearServiceItem(){
        itemServiceList.clear();
        totalService = 0.0;
    }
    public boolean isEmptyService(){
        return itemServiceList.isEmpty();
    }
    public Double getTotalService(){
        totalService = 0.0;
        for (BookServiceResortItem bookServiceResortItem:itemServiceList){
            totalService += bookServiceResortItem.getSubTotalService();
        }
        return totalService;
    }

}
