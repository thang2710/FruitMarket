package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
    @RequestMapping({"","index.html"})
    public String Home() {
        return "index.html()";
    }
}