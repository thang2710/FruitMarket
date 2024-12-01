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
        return "register";  // Trả về trang đăng ký
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String userName, @RequestParam String email, 
                               @RequestParam String password, @RequestParam String confirmPassword) {

        // Kiểm tra nếu mật khẩu và xác nhận mật khẩu khớp nhau
        if (!password.equals(confirmPassword)) {
            return "redirect:/register?error";  // Quay lại trang đăng ký nếu mật khẩu không khớp
        }

        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        String encodedPassword = passwordEncoder.encode(password);

        // Tạo đối tượng người dùng và lưu vào cơ sở dữ liệu
        UserEntity user = new UserEntity();
        user.setUserName(userName);  // Lưu tên đăng nhập
        user.setEmail(email);
        user.setPassWord(encodedPassword);  // Lưu mật khẩu mã hóa

        userRepository.save(user);

        return "redirect:/login";  // Chuyển hướng đến trang đăng nhập sau khi đăng ký thành công
    }
}