package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.model.User;

//find user name
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
