package com.laptrinhweb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import com.laptrinhweb.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf(cfrs -> cfrs.disable()).authorizeHttpRequests((auth) -> auth.
        requestMatchers("/*").permitAll().
        requestMatchers("/login/**").hasAnyAuthority("ADMIN").
        anyRequest().authenticated()).formLogin(login->login.loginPage("/login").loginProcessingUrl("/login").
        usernameParameter("username").passwordParameter("password").
        defaultSuccessUrl("/admin", true));
        return http.build();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web)->web.debug(true).ignoring().requestMatchers("/static/**", "/css/**");
    }
}
