package com.laptrinhweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/login")
public class LoginController {
@GetMapping()
public String index() {
    return "redirect:/login";
}

@RequestMapping("/")
    public String Login() {
        return "login";
    }
}

