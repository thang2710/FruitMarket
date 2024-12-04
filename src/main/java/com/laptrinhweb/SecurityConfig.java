package com.laptrinhweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.laptrinhweb.demo.service.CustomUserDetailsService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private final CustomUserDetailsService customUserDetailsService;
    @Bean
    public UserDetailsService userDetailsService(){
        return customUserDetailsService;
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){          //xác thực thông tin người dùng
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .csrf(AbstractHttpConfigurer::disable) // vô hiệu hóa CSRF nếu không cần thiết
            .formLogin(httpForm -> {
                httpForm.loginPage("/login").permitAll(); // trang đăng nhập tùy chỉnh
                httpForm.defaultSuccessUrl("/index");    // sau đăng nhập, chuyển tới /index
            })
            .logout(logout -> {
                logout.logoutUrl("/logout")           // Đặt URL logout
                    .logoutSuccessUrl("/index");     // Sau khi đăng xuất, chuyển hướng về /index
            })
            .authorizeHttpRequests(registry -> {   //cấp quyền truy cập
                registry.requestMatchers("/", "/index", "/signup", "/css/**", "/js/**", "/**").permitAll(); // Mở quyền truy cập cho các trang này
                registry.anyRequest().authenticated();  // các trang khác yêu cầu đăng nhập
            })
            .build();
    }

    
}
