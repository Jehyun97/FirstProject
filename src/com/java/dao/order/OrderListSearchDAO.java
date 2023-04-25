package com.java.dao.order;

import java.util.List;

import com.java.command.Criteria;
import com.java.dto.order.OrderListSearchVO;

public interface OrderListSearchDAO {

	List<OrderListSearchVO> selectOrderList(Criteria cri) throws Exception;
}
