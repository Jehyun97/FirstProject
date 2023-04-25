package com.java.dao.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.command.Criteria;
import com.java.dataSource.DataSource;
import com.java.dto.food.FoodVO;


public class FoodDAOImpl implements FoodDAO {

	private DataSource dataSource = DataSource.getInstance();

	@Override
	public List<FoodVO> selectFoodList(Criteria cri) throws SQLException {

		List<FoodVO> foodList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();

			String sql = "select * from food ";

			switch (cri.getSearchType()) {
			case "c":
				sql += " where f_code like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			case "n":
				sql += " where f_name like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			case "t":
				sql += " where f_category like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			}

			rs = stmt.executeQuery(sql);

			foodList = toFoodList(rs);

			return foodList;

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)conn.close();
		}

	}

	@Override
	public FoodVO selectFoodByFcode(String fcode) throws SQLException {

		FoodVO food = null;
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			String sql = "select * from food where f_code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fcode);

			ResultSet rs = pstmt.executeQuery();
			List<FoodVO> foodList = toFoodList(rs);
			if (foodList.size() > 0)
				food = foodList.get(0);

			return food;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)conn.close();
		}
	}
	
	

	@Override
	public void insertFood(FoodVO food) throws SQLException {

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = " insert into " + " food (f_code, f_name, f_origin, f_allergy, f_category, f_method, f_unit) "
					+ " values (?,?,?,?,?,?,?) ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, food.getFcode());
			pstmt.setString(2, food.getFname());
			pstmt.setString(3, food.getForigin());
			pstmt.setString(4, food.getFallergy());
			pstmt.setString(5, food.getFcategory());
			pstmt.setString(6, food.getFmethod());
			pstmt.setString(7, food.getFunit());

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
	public void updateFood(FoodVO food) throws SQLException {

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = " update food " + " set" + " f_name=?,f_origin=?,f_allergy=?,f_category=?,f_method=?,f_unit=?" + " where f_code=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, food.getFname());
			pstmt.setString(2, food.getForigin());
			pstmt.setString(3, food.getFallergy());
			pstmt.setString(4, food.getFcategory());
			pstmt.setString(5, food.getFmethod());
			pstmt.setString(6, food.getFunit());
			pstmt.setString(7, food.getFcode());

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
	public void deleteFood(String fcode) throws SQLException {

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from food where f_code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fcode);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	private List<FoodVO> toFoodList(ResultSet rs) throws SQLException {
		List<FoodVO> foodList = new ArrayList<FoodVO>();

		while (rs.next()) {
			FoodVO food = new FoodVO();

			food.setFallergy(rs.getString("f_allergy"));
			food.setFcategory(rs.getString("f_category"));
			food.setFcode(rs.getString("f_code"));
			food.setFname(rs.getString("f_name"));
			food.setFmethod(rs.getString("f_method"));
			food.setForigin(rs.getString("f_origin"));
			food.setFunit(rs.getString("f_unit"));

			foodList.add(food);
		}

		return foodList;
	}

}
