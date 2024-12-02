package com.laptrinhweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.laptrinhweb.demo.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Cho phép truy cập không cần xác thực cho các trang tĩnh và trang đăng ký/login
                .requestMatchers("/", "/register", "/login", "/css/**", "/js/**", "/ima/**","/sass/**", "/Source/**").permitAll()
                // Yêu cầu xác thực cho tất cả các yêu cầu còn lại
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")  // Trang đăng nhập tùy chỉnh
                .defaultSuccessUrl("/home", true)  // Sau khi đăng nhập thành công, chuyển đến trang home (có thể thay đổi theo nhu cầu)
                .permitAll()
            .and()
            .logout()
                .permitAll();
        
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return customUserDetailsService;  // Sử dụng CustomUserDetailsService để xác thực người dùng
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Mã hóa mật khẩu
    }
}




