package com.codegym.model;

import com.codegym.entity.Products;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> itemList;
    private Double total;

    public Cart() {
        itemList = new ArrayList<CartItem>();
        total = 0.0;
    }

    public CartItem getItem(Products products) {
        for (CartItem item : itemList) {
            if (item.getProducts().getId() == products.getId()) {
                return item;
            }
        }
        return null;// ko co gio hang trong item
    }

    //lay ve cac item
    public List<CartItem> getItemList() {
        return itemList;
    }

    // lay so luong item
    public Integer getItemCount() {
        return itemList.size();
    }

    //them mot item
    public void addItem(CartItem cartItem) {
        addItem(cartItem.getProducts(), cartItem.getQuality());
    }

    //them item voi so luong cho truong
    public void addItem(Products products, Integer quality) {
        CartItem cartItem = getItem(products);
        if (cartItem != null) {
            cartItem.setQuality(cartItem.getQuality() + quality);//so luong cu them so luong moi
        } else {
            cartItem = new CartItem(products);//tao moi
            cartItem.setQuality(quality);//set so luong
            itemList.add(cartItem); // them vao list cac item
        }
    }

    //update san pham
    public void updateItem(Products products, Integer quality) {
        CartItem cartItem = getItem(products);// laays veef sap phaamr caanf update
        if (cartItem != null) {
            cartItem.setQuality(quality);
        }
    }

    //xoa san pham
    public void removeItem(Products products) {
        CartItem cartItem = getItem(products);
        if (cartItem != null) {
            itemList.remove(cartItem);// item
        }
    }

    //xoa toan bo gio hang
    public void clear() {
        itemList.clear();
        total = 0.0;
    }

    //kiem tra gio hang co trong hay ko
    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    //Lay tong tien
    public double getTotal() {
        total = 0.0;
        for (CartItem cartItem : itemList) {
            total += cartItem.getSubTotal();
        }
        return total;
    }
}
