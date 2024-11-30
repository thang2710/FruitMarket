package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@RequestMapping("/home")
    public String Home() {
        return " index.html() ";
    }
}

