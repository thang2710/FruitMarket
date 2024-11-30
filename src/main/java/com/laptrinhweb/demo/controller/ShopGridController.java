package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ShopGridController {
@RequestMapping("/shop-grid.html")
    public String Blog() {
        return "shop-grid.html";
    }
}
