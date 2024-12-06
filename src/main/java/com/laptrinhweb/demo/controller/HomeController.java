package com.laptrinhweb.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/blog")
    public String blogPage(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "blog";
    }
    @GetMapping("/contact")
    public String contactPage(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "contact";
    }
    @GetMapping("/checkout")
    public String checkoutPage(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "checkout";
    }
    @GetMapping("/shop-details")
    public String shopDetailPage(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "shop-details";
    }
    @GetMapping("/shop-grid")
    public String shopGridPage(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "shop-grid";
    }
    @GetMapping("/shoping-cart")
    public String shopingCartPage(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "shoping-cart";
    }

    
}