package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopDetailController {
@RequestMapping("/shop-details.html")
    public String Blog() {
        return "shop-details.html";
    }
}

