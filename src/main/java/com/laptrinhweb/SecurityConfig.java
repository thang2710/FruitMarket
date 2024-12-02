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
    public AuthenticationProvider authenticationProvider(){
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
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .formLogin(httpForm ->{
                httpForm.loginPage("/trangchu/login").permitAll();
                httpForm.defaultSuccessUrl("/index",true);
                
            })
    
            
            .authorizeHttpRequests(registry ->{
                registry.requestMatchers("/trangchu/register","/css/**","/js/**","/fonts/**","/img/**","/sass/**", "/Source/**","/index").permitAll();
                registry.anyRequest().authenticated();
            })
            .build();
    }
    
}
