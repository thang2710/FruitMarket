package com.laptrinhweb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhweb.demo.model.RegisterLogin.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserNameAndPassWord(String userName, String passWord);

    
}