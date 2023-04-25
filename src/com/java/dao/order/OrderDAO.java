package com.java.dao.order;

import java.sql.SQLException;
import java.util.List;

import com.java.command.Criteria;
import com.java.dto.order.OrderVO;

public interface OrderDAO {
	
	List<OrderVO> selectOrderList(Criteria cri) throws SQLException;

	OrderVO selectOrderByOcode(String Ocode) throws SQLException;

	void insertOrder(OrderVO orderr) throws SQLException;

	void updateOrder(OrderVO orderr) throws SQLException;

	void deleteOrder(String Ocode) throws SQLException;

}
