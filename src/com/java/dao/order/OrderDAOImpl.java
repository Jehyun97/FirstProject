package com.java.dao.order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.command.Criteria;
import com.java.dataSource.DataSource;
import com.java.dto.order.OrderVO;


public class OrderDAOImpl implements OrderDAO {
	
	private DataSource dtSource = DataSource.getInstance();
	@Override
	public List<OrderVO> selectOrderList(Criteria cri) throws SQLException {

		List<OrderVO> orderrList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dtSource.getConnection();
			stmt = conn.createStatement();

			String sql = "select * from orderr ";

			switch (cri.getSearchType()) {
			case "o": // 아이디 검색
				sql += "  where o_code like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			case "s": // 이름검색
				sql += "  where s_num like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			case "d": // 전화번호 검색
				sql += "  where o_date like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
		
			}

			rs = stmt.executeQuery(sql);

			orderrList = toOrderList(rs);

			return orderrList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	@Override
	public OrderVO selectOrderByOcode(String Ocode) throws SQLException {
		OrderVO member = null;
		Connection conn = null;
		try {
			conn = dtSource.getConnection();
			conn = dtSource.getConnection();
			String sql = "select * from orderr where o_code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Ocode);
			ResultSet rs = pstmt.executeQuery();
			List<OrderVO> memberList = toOrderList(rs);
			if (memberList.size() > 0)
				member = memberList.get(0);

			return member;

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void insertOrder(OrderVO orderr) throws SQLException {
		Connection conn = null;
		try {
			conn = dtSource.getConnection();
			String sql = " insert into" + "  orderr(o_code, f_code, s_num, o_date,o_qty)"
					+ "  values(?,?,?,to_date(?),?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderr.getOcode());
			pstmt.setString(2, orderr.getFcode());
			pstmt.setString(3, orderr.getSnum());
			pstmt.setDate(4, (Date) orderr.getOdate());
			pstmt.setInt(5, orderr.getOqty());
			

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}
		
	
	@Override
	public void updateOrder(OrderVO orderr) throws SQLException {

		Connection conn = null;
		try {
			conn = dtSource.getConnection();
			String sql = "update orderr" + " set" + " f_code=?,s_num=?,o_date=?,o_qty=? "
					+ " where o_code = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderr.getFcode());
			pstmt.setString(2, orderr.getSnum());
			pstmt.setDate(3, (Date) orderr.getOdate());
			pstmt.setInt(4, orderr.getOqty());
			pstmt.setString(5, orderr.getOcode());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	@Override
	public void deleteOrder(String Ocode) throws SQLException {
		Connection conn = null;
		try {
			conn = dtSource.getConnection();
			String sql = "delete from orderr where o_code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Ocode);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}

	}


		private List<OrderVO> toOrderList(ResultSet rs) throws SQLException{
			
			List<OrderVO> orderrList = new ArrayList<OrderVO>();
			while (rs.next()) {
				OrderVO orderr = new OrderVO();
				orderr.setOcode(rs.getString("O_code"));
				orderr.setFcode(rs.getString("F_code"));
				orderr.setSnum(rs.getString("S_num"));
				orderr.setOdate(rs.getDate("O_date"));
				orderr.setOqty(rs.getInt("O_qty"));
				
				
			

				orderrList.add(orderr);
			}
			return orderrList;

}
}

