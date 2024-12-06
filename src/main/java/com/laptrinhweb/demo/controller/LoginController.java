package com.laptrinhweb.demo.controller;


import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhweb.demo.entity.UserEntity;
import com.laptrinhweb.demo.repository.UserRepository;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginForm(){
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

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Tìm người dùng theo tên đăng nhập
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);

        // Kiểm tra nếu người dùng không tồn tại hoặc mật khẩu sai
        if (userOptional.isEmpty() || !userOptional.get().getPassword().equals(password)) {
            model.addAttribute("loginError", true);
            return "form/login";
        }
        return "redirect:/index";  
    }
   
    
}

