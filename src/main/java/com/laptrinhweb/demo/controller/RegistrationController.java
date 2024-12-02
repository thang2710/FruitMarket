package com.laptrinhweb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhweb.demo.entity.UserEntity;
import com.laptrinhweb.demo.repository.UserRepository;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/register")
    public String showRegistrationForm() {
        return "register"; 
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String userName, @RequestParam String email, 
                               @RequestParam String passWord, @RequestParam String confirmPassword) {

     
        if (!passWord.equals(confirmPassword)) {
            return "redirect:/register?error"; 
        }


        String encodedPassword = passwordEncoder.encode(passWord);

       
        UserEntity user = new UserEntity();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassWord(encodedPassword);

        userRepository.save(user);

        return "redirect:/login";
    }
}