package com.laptrinhweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.model.User;
import com.laptrinhweb.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUserName(String userName) {
        // TODO Auto-generated method stub
        return userRepository.findByUserName(userName);
    }
}
