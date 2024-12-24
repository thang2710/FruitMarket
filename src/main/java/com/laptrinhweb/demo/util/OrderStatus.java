package com.laptrinhweb.demo.util;

public enum OrderStatus {

	IN_PROGRESS(1, "Đang Xử Lý"), ORDER_RECEIVED(2, "Đơn Hàng Đã Nhận"), PRODUCT_PACKED(3, "Sản Phẩm Đã Đóng Gói"),
	OUT_FOR_DELIVERY(4, "Đang Giao Hàng"), DELIVERED(5, "Đã Giao"),CANCEL(6,"Đã Hủy"),SUCCESS(7,"Thành Công");

	private Integer id;

	private String name;

	private OrderStatus(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
