package cc.edt.frame.base.dao;


import cc.edt.frame.model.entity.base.Order;

import java.util.List;


public interface OrderDao {

	Order getOrderById(int orderId);

	void saveOrder(Order order);

	void updateOrder(Order order);

	void deleteOrder(int orderId);

	List<Order> getAllOrder();
}
