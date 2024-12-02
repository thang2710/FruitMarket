package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/blog")
    public String blogPage() {
        return "blog";
    }
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
    @GetMapping("/checkout")
    public String checkoutPage() {
        return "checkout";
    }
    @GetMapping("/shop-details")
    public String shopDetailPage() {
        return "shop-details";
    }
    @GetMapping("/shop-grid")
    public String shopGridPage() {
        return "shop-grid";
    }
    @GetMapping("/shoping-cart")
    public String shopingCartPage() {
        return "shoping-cart";
    }

    
}