package com.codegym.controller;

import com.codegym.entity.Products;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping({"/", "/index"})
    public String goIndex() {
        return "index";
    }

    @RequestMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop";
    }

    @RequestMapping("/cart")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/product/{id}")
    public String product(@PathVariable("id") Long id, Model model) {
        Products products = productService.findById(id);
        model.addAttribute("product", products);
        return "products";
    }

}
