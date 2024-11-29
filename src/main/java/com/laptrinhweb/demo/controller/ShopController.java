package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ShopController {

    @RequestMapping("/shop")
    public String  Shop() {
        return "shop-grid.html";
    }
    @RequestMapping("/contact")
    public String  Contact() {
        return "contact.html";
    }
    @RequestMapping("/checkout")
    public String  checkout() {
        return "checkout.html";

    }
     @RequestMapping("/ShopDetails")
    public String  ShopDetails() {
        return "shop-details.html";
        
    }
}
