package com.laptrinhweb.demo.controller;


import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping({"/", "/index"})
    public String index(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "index";
    }
    // @GetMapping({"/", "/index"})
    // public String home() {
    //     return "index";
    // }
    
}

