package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
@RequestMapping("/blog.html")
    public String Blog() {
        return "blog.html";
    }
}

