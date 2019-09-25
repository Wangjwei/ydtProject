package cc.edt.frame.base.service;

import cc.edt.frame.model.entity.base.Order;

import java.util.List;

public interface OrderService {
	Order getOrderById(int orderId);

	void saveOrder(Order order);

	void updateOrder(Order order);

	void deleteOrder(int orderId);

	List<Order> getAllOrder();
}
