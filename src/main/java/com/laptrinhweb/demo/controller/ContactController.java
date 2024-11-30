package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ContactController {
@RequestMapping("/contact.html")
    public String Blog() {
        return "contact.html";
    }
}

