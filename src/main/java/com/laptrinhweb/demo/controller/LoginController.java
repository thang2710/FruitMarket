package com.laptrinhweb.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "/form/login";
    }
    
    @GetMapping("/register")
    public String signup(){
        return "/form/register";
    }
    
}

