package com.laptrinhweb.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.demo.entity.Cart;
import com.laptrinhweb.demo.entity.UserDtls;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public Cart findByProductIdAndUserId(Integer productId, Integer userId);

	public Integer countByUserId(Integer userId);

	public List<Cart> findByUserId(Integer userId);

	public UserDtls deleteByUserId(Integer userId);

}
