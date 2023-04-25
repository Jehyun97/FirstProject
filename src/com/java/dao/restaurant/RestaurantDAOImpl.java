package com.java.dao.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.command.Criteria;
import com.java.dataSource.DataSource;
import com.java.dto.restaurant.RestaurantVO;

public class RestaurantDAOImpl implements RestaurantDAO{
	
	private DataSource dataSource = DataSource.getInstance();

	@Override
	public List<RestaurantVO> selectRestaurantList(Criteria cri) throws SQLException {
		
		List<RestaurantVO> restaurantList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			
			String sql = "select * from Restaurant";
			
			switch (cri.getSearchType()) {
			
			case "c":
				sql += " where r_code like '%'||'"+cri.getKeyword()+"'||'%'";
				break;
			case "n":
				sql += " where r_name like '%'||'"+cri.getKeyword()+"'||'%'";
				break;
			}
			
			rs = stmt.executeQuery(sql);
			
			restaurantList = toRestaurantList(rs);
			
			return restaurantList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if (conn!=null)conn.close();
		}
		
		
	}

	@Override
	public RestaurantVO selectRestaurantByRcode(String rcode) throws SQLException {
		
		RestaurantVO restaurant = null;
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select * from restaurant where r_code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rcode);
			
			ResultSet rs = pstmt.executeQuery();
			List<RestaurantVO> restaurantList = toRestaurantList(rs);
			if (restaurantList.size() > 0)
				restaurant = restaurantList.get(0);

			return restaurant;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if (conn != null)conn.close();
			}
	}
	

	@Override
	public void insertRestaurant(RestaurantVO restaurant) throws SQLException {
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = " insert into " 
						+ " restaurant(r_code, r_name, r_phone)"
						+ " values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, restaurant.getRcode());
			pstmt.setString(2, restaurant.getRname());
			pstmt.setString(3, restaurant.getRphone());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void updateRestaurant(RestaurantVO restaurant) throws SQLException {
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = " update restaurant " 
						+ " set" 
						+ " r_name=?,r_phone=?" 
						+ " where r_code=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, restaurant.getRname());
			pstmt.setString(2, restaurant.getRphone());
			pstmt.setString(3, restaurant.getRcode());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void deleteRestaurant(String rcode) throws SQLException {
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from restaurant where r_code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rcode);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
		
	}
	private List<RestaurantVO> toRestaurantList(ResultSet rs) throws SQLException {
		List<RestaurantVO> restaurantList = new ArrayList<RestaurantVO>();

		while (rs.next()) {
			RestaurantVO restaurant = new RestaurantVO();

			restaurant.setRcode(rs.getString("r_code"));
			restaurant.setRname(rs.getString("r_name"));
			restaurant.setRphone(rs.getString("r_phone"));

			restaurantList.add(restaurant);
		}

		return restaurantList;
	}


}
