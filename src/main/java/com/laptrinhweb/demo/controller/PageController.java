package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/blog")
    public String getBlog() {
        return "blog";
    }

    @GetMapping("/checkout")
    public String getCheckout() {
        return "checkout";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }

    

    
}
