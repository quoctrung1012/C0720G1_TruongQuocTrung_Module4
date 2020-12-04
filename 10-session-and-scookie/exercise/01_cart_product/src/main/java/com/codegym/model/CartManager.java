package com.codegym.model;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class CartManager {
    private static final String SESSION_KEY_SHOPPING = "gioHang";
    public Cart getCart(HttpSession session){
        Cart cart = (Cart) session.getAttribute(SESSION_KEY_SHOPPING);
        if ((cart == null)){
            cart = new Cart();
            serCart(session, cart);
        }
        return cart;
    }
    //thiet lap gio hang
    public void serCart(HttpSession session, Cart cart){
        session.setAttribute(SESSION_KEY_SHOPPING, cart);
    }
    //xoas mot gio hang
    public void removeCart(HttpSession session){
        session.removeAttribute(SESSION_KEY_SHOPPING);
    }
}
