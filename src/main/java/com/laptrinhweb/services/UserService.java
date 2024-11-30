package com.laptrinhweb.services;

import com.laptrinhweb.model.User;


public interface UserService {
    User findByUserName(String userName);
}
