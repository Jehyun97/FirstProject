package com.java.service.order;

import java.util.List;

import com.java.command.Criteria;
import com.java.dao.order.OrderListSearchDAO;
import com.java.dao.order.OrderListSearchDAOImpl;
import com.java.dto.order.OrderListSearchVO;

public class OrderLIstSearchServiceImpl implements OrderListSearchService {

	private OrderListSearchDAO orderDAO = new OrderListSearchDAOImpl();

	public void setOrderDAO(OrderListSearchDAO orderDAO) {
		this.orderDAO = orderDAO;

	}

	@Override
	public List<OrderListSearchVO> getOrderList(Criteria cri) throws Exception {
		List<OrderListSearchVO> orderList = orderDAO.selectOrderList(cri);
		return orderList;
	}

}
