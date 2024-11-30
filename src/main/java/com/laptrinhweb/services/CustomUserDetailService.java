package com.laptrinhweb.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhweb.model.CustomUserDetails;
import com.laptrinhweb.model.User;
import com.laptrinhweb.model.User_Role;

//check user name, load role xem có khớp
@Service
public class CustomUserDetailService implements UserDetailsService{
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException("Username not found");
        }
        //find Role
        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        Set<User_Role> roles = user.getUserRoles();

        for (User_Role user_Role : roles) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(user_Role.getRole().getName()));
        }
        return new CustomUserDetails(user, grantedAuthoritySet);
    }
}
