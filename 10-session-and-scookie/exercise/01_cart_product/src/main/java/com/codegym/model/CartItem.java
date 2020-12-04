package com.codegym.model;

import com.codegym.entity.Products;

public class CartItem {
    private Products products;
    private Integer quality;
    private Double subTotal;

    public CartItem(Products products) {
        this.products = products;
        this.quality = 1;// khoi tao so luong
        this.subTotal = products.getPrice();// tinh tien mot san pham
    }

    public CartItem() {
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Double getSubTotal() {
        subTotal = products.getPrice() * quality;
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
