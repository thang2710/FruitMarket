package com.laptrinhweb.demo.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhweb.demo.entity.Cart;
import com.laptrinhweb.demo.entity.OrderAddress;
import com.laptrinhweb.demo.entity.OrderRequest;
import com.laptrinhweb.demo.entity.ProductOrder;
import com.laptrinhweb.demo.entity.UserDtls;
import com.laptrinhweb.demo.repository.CartRepository;
import com.laptrinhweb.demo.repository.ProductOrderRepository;
import com.laptrinhweb.demo.repository.UserRepository;
import com.laptrinhweb.demo.service.OrderService;
import com.laptrinhweb.demo.util.CommonUtil;
import com.laptrinhweb.demo.util.OrderStatus;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductOrderRepository orderRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CommonUtil commonUtil;

	@Transactional
	@Override
	public void saveOrder(Integer userid, OrderRequest orderRequest) throws Exception {

		// Lấy toàn bộ sản phẩm trong giỏ hàng của người dùng
        List<Cart> carts = cartRepository.findByUserId(userid);

        if (!carts.isEmpty()) {
			// Lấy ngày hiện tại để gộp đơn hàng cùng ngày
			LocalDate currentDate = LocalDate.now();
			
			// Tạo một orderId duy nhất cho ngày hôm đó (Có thể sử dụng UUID hoặc bất kỳ định dạng nào)
			String orderId = "ORDER-" + currentDate.toString() + "-" + UUID.randomUUID().toString();
			
			for (Cart cart : carts) {
				ProductOrder order = new ProductOrder();
	
				// Đặt orderId chung cho tất cả đơn hàng trong ngày
				order.setOrderId(orderId);
				order.setOrderDate(currentDate);
	
				order.setProduct(cart.getProduct());
				order.setPrice(cart.getProduct().getDiscountPrice());
				order.setQuantity(cart.getQuantity());
				order.setUser(cart.getUser());
	
				order.setStatus(OrderStatus.IN_PROGRESS.getName());
				order.setPaymentType(orderRequest.getPaymentType());
	
				// Thêm thông tin địa chỉ giao hàng
				OrderAddress address = new OrderAddress();
				address.setFirstName(orderRequest.getFirstName());
				address.setLastName(orderRequest.getLastName());
				address.setEmail(orderRequest.getEmail());
				address.setMobileNo(orderRequest.getMobileNo());
				address.setAddress(orderRequest.getAddress());
				address.setCity(orderRequest.getCity());
				address.setState(orderRequest.getState());
				address.setPincode(orderRequest.getPincode());
	
				order.setOrderAddress(address);
	
				// Lưu đơn hàng
				ProductOrder savedOrder = orderRepository.save(order);
	
			}
		}
        // // Xóa giỏ hàng sau khi lưu xong
        // cartRepository.deleteByUserId(userid);

	}

	@Override
	public Integer getUserIdByEmail(String email) {
		UserDtls user = userRepository.findByEmail(email);
		return user != null ? user.getId() : null;
	}

	@Override
	public List<ProductOrder> getOrdersByUser(Integer userId) {
		List<ProductOrder> orders = orderRepository.findByUserId(userId);
		return orders;
	}

	@Override
	public ProductOrder updateOrderStatus(Integer id, String status) {
		Optional<ProductOrder> findById = orderRepository.findById(id);
		if (findById.isPresent()) {
			ProductOrder productOrder = findById.get();
			productOrder.setStatus(status);
			ProductOrder updateOrder = orderRepository.save(productOrder);
			return updateOrder;
		}
		return null;
	}

	@Override
	public List<ProductOrder> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Page<ProductOrder> getAllOrdersPagination(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return orderRepository.findAll(pageable);

	}

	@Override
	public List<ProductOrder> getOrdersByOrderId(String orderId) {
		return orderRepository.findByOrderIdContaining(orderId);
	}

}
