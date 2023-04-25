package com.java.dao.order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.command.Criteria;
import com.java.dataSource.DataSource;
import com.java.dto.order.OrderListSearchVO;


public class OrderListSearchDAOImpl implements OrderListSearchDAO {

	private DataSource dtSource = DataSource.getInstance();

	// @Override
	// public List<OrderVO> selectOrderAllList() throws Exception {
	//
	// Connection conn = dtSource.getConnection();
	// Statement stmt = null;
	// ResultSet rs = null;
	//
	// try {
	// stmt =conn.createStatement();
//		
//		String sql=" select * from order_list order by o_date desc";
//		rs = stmt.executeQuery(sql);
//		
//		List<OrderVO> orderList = new ArrayList<OrderVO>();
//		
//		while(rs.next()) {
//			OrderVO order = new OrderVO();
//			
//			order.setFcode(rs.getString("F_code"));
//			order.setFname(rs.getString("F_name"));
//			order.setOcode(rs.getString("O_code"));
//			order.setOdate(rs.getDate("O_date"));
//			order.setOqty(rs.getInt("O_qty"));
//			order.setSnum(rs.getString("S_num"));
//			order.setWname(rs.getString("W_name"));
//			
//			orderList.add(order);
//		}
//		
//		return orderList;
//		
//				
//		
//
//		} finally {
//			if(rs!=null)rs.close();
//			if(stmt!=null)stmt.close();
//			
//			
//			
//		}
//		
//	
//	}

	@Override
	public List<OrderListSearchVO> selectOrderList(Criteria cri) throws SQLException {

		List<OrderListSearchVO> orderList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dtSource.getConnection();
			stmt = conn.createStatement();

			String sql = "select * from order_list ";

			switch (cri.getSearchType()) {
			case "d": // 아이디 검색
				sql += "  where o_date like '%'||'" + cri.getKeyword() + "'||'%'" + "order by o_date desc";
				break;
			case "s": // 이름검색
				sql += "  where s_num like '%'||'" + cri.getKeyword() + "'||'%'" + "order by o_date desc";
				break;
			case "":
				sql += " order by o_date desc";
			}

			rs = stmt.executeQuery(sql);

			orderList = toOrderList(rs);
			return orderList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	private List<OrderListSearchVO> toOrderList(ResultSet rs) throws SQLException {
		List<OrderListSearchVO> orderList = new ArrayList<OrderListSearchVO>();
		while (rs.next()) {
			OrderListSearchVO order = new OrderListSearchVO();
			order.setOcode(rs.getString("O_code"));
			order.setFcode(rs.getString("F_code"));
			order.setSnum(rs.getString("S_num"));
			order.setOdate(rs.getDate("O_date"));
			order.setFname(rs.getString("F_name"));
			order.setOqty(rs.getInt("O_qty"));
			order.setWname(rs.getString("W_name"));

			orderList.add(order);
		}
		return orderList;

	}

}