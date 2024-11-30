package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CheckOutController {
@RequestMapping("/checkout.html")
    public String Blog() {
        return "checkout.html";
    }
}

