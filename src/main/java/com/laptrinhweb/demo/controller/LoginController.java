package com.laptrinhweb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhweb.demo.entity.UserEntity;
import com.laptrinhweb.demo.repository.UserRepository;



@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository; // Giả sử bạn có repository cho UserEntity

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Tìm người dùng theo tên người dùng
        UserEntity user = userRepository.findByUsername(username);

        // Kiểm tra mật khẩu
        if (user != null && user.getPassWord().equals(password)) {
            // Nếu đăng nhập thành công
            return "redirect:/home"; // Chuyển hướng đến trang chủ (hoặc trang bạn muốn)
        } else {
            // Nếu đăng nhập thất bại
            model.addAttribute("error", "Sai tên người dùng hoặc mật khẩu.");
            return "login"; // Quay lại trang login với thông báo lỗi
        }
    }
}

