package com.java.dao.restaurant;

import java.sql.SQLException;
import java.util.List;

import com.java.command.Criteria;
import com.java.dto.restaurant.RestaurantVO;

public interface RestaurantDAO {
	
	List<RestaurantVO> selectRestaurantList(Criteria cri) throws SQLException;
	
	RestaurantVO selectRestaurantByRcode(String rcode)throws SQLException;
	
	void insertRestaurant(RestaurantVO restaurant)throws SQLException;

	void updateRestaurant(RestaurantVO restaurant)throws SQLException;
	
	void deleteRestaurant(String rcode)throws SQLException;

}
