package com.laptrinhweb.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "form/login";
    }
    
    @GetMapping("/signup")
    public String signup(){
        return "form/signup";
    }
    @GetMapping({"/","/index"})
    public String home(){
        return "index";
    }
    
}

