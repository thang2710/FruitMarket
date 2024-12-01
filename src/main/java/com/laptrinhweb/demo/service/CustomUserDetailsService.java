package com.laptrinhweb.demo.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.laptrinhweb.demo.entity.UserEntity;
import com.laptrinhweb.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;  // Giả sử bạn có một UserRepository để truy xuất dữ liệu người dùng

    @Autowired
    private PasswordEncoder passwordEncoder;  // Để mã hóa mật khẩu nếu cần thiết

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // Tìm người dùng trong cơ sở dữ liệu bằng tên đăng nhập
        UserEntity user = userRepository.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }

        // Lấy thông tin người dùng và trả về đối tượng UserDetails (Spring Security User)
        return new User(user.getUserName(), user.getPassWord(), Collections.emptyList());
    }
}

