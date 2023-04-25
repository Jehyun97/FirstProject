package com.java.service.restaurant;

import java.util.List;

import com.java.command.Criteria;
import com.java.dto.restaurant.RestaurantVO;

public interface RestaurantService {
	
	public List<RestaurantVO> getRestaurantList(Criteria cri)throws Exception;
	
	public RestaurantVO getRestaurant(String rcode)throws Exception;
	
	public void regist(RestaurantVO restaurant)throws Exception;

	public void modify(RestaurantVO restaurant)throws Exception;

	public void remove(String rcode)throws Exception;
	

}
