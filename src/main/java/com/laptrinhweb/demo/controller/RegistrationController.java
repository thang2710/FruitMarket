package com.laptrinhweb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

import com.laptrinhweb.demo.entity.UserEntity;
import com.laptrinhweb.demo.repository.UserRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    
    @Autowired
    private UserRepository myAppUserRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping(value = "/trangchu/register", consumes = "application/json")
    public UserEntity createUser(@RequestBody UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myAppUserRepository.save(user);
    }
}   