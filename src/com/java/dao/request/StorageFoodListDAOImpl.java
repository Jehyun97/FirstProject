package com.java.dao.request;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.command.Criteria;
import com.java.dataSource.DataSource;
import com.java.dto.request.StorageFoodListVO;

public class StorageFoodListDAOImpl implements StorageFoodListDAO {
	private DataSource datasource = DataSource.getInstance();

	@Override
	public List<StorageFoodListVO> selectStorageFoodList(Criteria cri) throws SQLException {
		List<StorageFoodListVO> foodlist = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		//Criteria cri = new Criteria();
		try {
			conn = datasource.getConnection();
			stmt = conn.createStatement();

			String sql = "select s_num,f_name, sum (sd_qty)" + 
					" from \"Food_List\"" + 
					" GROUP by f_name,s_num";
			
			
			rs = stmt.executeQuery(sql);
			foodlist = toStorageFoodList(rs);
			return foodlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	private List<StorageFoodListVO> toStorageFoodList(ResultSet rs) throws SQLException {
		List<StorageFoodListVO> foodList = new ArrayList<StorageFoodListVO>();
		while (rs.next()) {
			StorageFoodListVO food = new StorageFoodListVO();
			food.setS_num(rs.getString("s_num"));
			food.setF_name(rs.getString("f_name"));
			food.setSD_qty(rs.getInt("sum(sd_qty)"));

			foodList.add(food);
		}

		return foodList;

	}

}