package com.laptrinhweb.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhweb.demo.entity.UserEntity;
import com.laptrinhweb.demo.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor 
public class CustomUserDetailsService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();    
        }else{
            throw new UsernameNotFoundException(username);
        }
    }
    
    
    
}


