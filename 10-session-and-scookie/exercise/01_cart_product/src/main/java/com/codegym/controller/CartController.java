package com.codegym.controller;

import com.codegym.entity.Products;
import com.codegym.model.Cart;
import com.codegym.model.CartManager;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartManager cartManager;

    @RequestMapping("/add")
    public String add(HttpSession session, @RequestParam("id") Long id,
                      @RequestParam(value = "quality" , required = false,defaultValue = "1") Integer quality){
        Products product = productService.findById(id);
        Cart cart = cartManager.getCart(session);// lay ve gio hang
        cart.addItem(product, quality);// them san pham, so luong vao gio hang
        return "redirect:/shop";
    }
    @RequestMapping("/remove")// Xoa sp trong gio
    public String remove(HttpSession session, @RequestParam("id") Long id){
        Products product = productService.findById(id);
        Cart cart = cartManager.getCart(session);
        cart.removeItem(product);
        return "cart";
    }
    @RequestMapping("/update")
    public String update(HttpSession session, @RequestParam("id") Long id, @RequestParam("quality") Integer quality){
        Products product = productService.findById(id);
        Cart cart = cartManager.getCart(session);
        cart.updateItem(product, quality);
        return "cart";
    }
}
