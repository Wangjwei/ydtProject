package cc.edt.frame.base.service.impl;

import cc.edt.frame.base.dao.OrderDao;
import cc.edt.frame.base.service.OrderService;
import cc.edt.frame.model.entity.base.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao orderDao;

	@Override
	public Order getOrderById(int orderId) {
		return orderDao.getOrderById(orderId);
	}

	@Override
	public void saveOrder(Order order) {
		orderDao.saveOrder(order);
	}

	@Override
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
	}

	@Override
	public void deleteOrder(int orderId) {
		orderDao.deleteOrder(orderId);
	}

	@Override
	public List<Order> getAllOrder() {
		return orderDao.getAllOrder();
	}
}
