package com.java.service.order;

import java.util.List;

import com.java.command.Criteria;
import com.java.dto.order.OrderListSearchVO;

public interface OrderListSearchService {

	public List<OrderListSearchVO> getOrderList(Criteria cri) throws Exception;

}
