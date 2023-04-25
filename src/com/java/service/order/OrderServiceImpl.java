package com.java.service.order;

import java.util.List;

import com.java.command.Criteria;
import com.java.dao.order.OrderDAO;
import com.java.dao.order.OrderDAOImpl;
import com.java.dto.order.OrderVO;

public class OrderServiceImpl implements OrderService {

	private OrderDAO orderrDAO = new OrderDAOImpl();

	public void setOrderrDAO(OrderDAO orderrDAO) {
		this.orderrDAO = orderrDAO;
	}

	@Override
	public List<OrderVO> getOrderList(Criteria cri) throws Exception {
		List<OrderVO> orderrList = orderrDAO.selectOrderList(cri);
		return orderrList;
	}

	@Override
	public OrderVO getOrder(String Ocode) throws Exception {
		OrderVO orderr = orderrDAO.selectOrderByOcode(Ocode);
		return orderr;
	}

	@Override
	public void regist(OrderVO orderr) throws Exception {
		orderrDAO.insertOrder(orderr);

	}

	@Override
	public void modify(OrderVO orderr) throws Exception {
		orderrDAO.updateOrder(orderr);

	}

	@Override
	public void remove(String Ocode) throws Exception {
		orderrDAO.deleteOrder(Ocode);

	}
}
