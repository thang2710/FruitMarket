package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PagesController {
@RequestMapping("/blogs")
public String Blog_detail() {
    return "blog-details.html";
    }
}
