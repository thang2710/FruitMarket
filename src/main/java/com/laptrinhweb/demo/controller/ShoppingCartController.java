package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {
@RequestMapping("/shop-cart.html")
    public String Blog() {
        return "shoping-cart.html";
    }
}
