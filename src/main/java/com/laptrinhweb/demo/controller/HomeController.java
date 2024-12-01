package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @GetMapping("/")
    public String indexPage() {
        return "index"; // Trả về file templates/index.html
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

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String loginPage() {
        return "form/login";
    }
    @RequestMapping(value = "/register", method=RequestMethod.GET)
    public String registerPage() {
        return "form/register";
    }
    
}