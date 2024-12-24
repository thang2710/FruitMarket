package com.laptrinhweb.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.laptrinhweb.demo.entity.OrderRequest;
import com.laptrinhweb.demo.entity.ProductOrder;

public interface OrderService {

	public void saveOrder(Integer userid, OrderRequest orderRequest) throws Exception;

	public List<ProductOrder> getOrdersByUser(Integer userId);

	public ProductOrder updateOrderStatus(Integer id, String status);

	public List<ProductOrder> getAllOrders();

	public List<ProductOrder> getOrdersByOrderId(String orderId);
	
	public Page<ProductOrder> getAllOrdersPagination(Integer pageNo,Integer pageSize);

	public Integer getUserIdByEmail(String email);
}
