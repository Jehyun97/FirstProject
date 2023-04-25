package com.java.service.order;

import java.util.List;

import com.java.command.Criteria;
import com.java.dto.order.OrderVO;

public interface OrderService {

	public List<OrderVO> getOrderList(Criteria cri) throws Exception;

	public OrderVO getOrder(String Ocode) throws Exception;

	public void regist(OrderVO orderr) throws Exception;

	public void modify(OrderVO orderr) throws Exception;

	public void remove(String Ocode) throws Exception;

}
