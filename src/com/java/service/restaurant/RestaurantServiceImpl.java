package com.java.service.restaurant;

import java.util.List;

import com.java.command.Criteria;
import com.java.dao.restaurant.RestaurantDAO;
import com.java.dao.restaurant.RestaurantDAOImpl;
import com.java.dto.restaurant.RestaurantVO;

public class RestaurantServiceImpl implements RestaurantService{
	
	private RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
	public void setRestaurantDAO(RestaurantDAO restaurantDAO) {
		this.restaurantDAO = restaurantDAO;
	}

	@Override
	public List<RestaurantVO> getRestaurantList(Criteria cri) throws Exception {
		List<RestaurantVO> restaurantList = restaurantDAO.selectRestaurantList(cri);
		return restaurantList;
	}

	@Override
	public RestaurantVO getRestaurant(String rcode) throws Exception {
		RestaurantVO restaurant = restaurantDAO.selectRestaurantByRcode(rcode); 
		return restaurant;
	}

	@Override
	public void regist(RestaurantVO restaurant) throws Exception {
		restaurantDAO.insertRestaurant(restaurant);
		
	}

	@Override
	public void modify(RestaurantVO restaurant) throws Exception {
		restaurantDAO.updateRestaurant(restaurant);
		
	}

	@Override
	public void remove(String rcode) throws Exception {
		restaurantDAO.deleteRestaurant(rcode);
	}

}
