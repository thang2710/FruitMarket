package com.laptrinhweb.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("trangchu/login")
    public String login(){
        return "/form/login";
    }
    
    @GetMapping("/trangchu/register")
    public String signup(){
        return "/form/register";
    }
    @GetMapping("/index")
    public String home(){
        return "index";
    }
    
}

