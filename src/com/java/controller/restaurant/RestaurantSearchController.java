package com.java.controller.restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.restaurant.RestaurantVO;
import com.java.service.restaurant.RestaurantService;
import com.java.service.restaurant.RestaurantServiceImpl;
import com.java.views.restaurant.RestaurantSearchView;


public class RestaurantSearchController extends Controller{
	
	private RestaurantSearchView searchFormView = new RestaurantSearchView();
	private RestaurantService restaurantService = new RestaurantServiceImpl();


	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		Criteria cri = new Criteria();
		cri.setSearchType("");
		cri.setKeyword("");
		
		while(flag) {

			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			List<RestaurantVO> restaurantList = null;
			
	

			try {
				restaurantList = restaurantService.getRestaurantList(cri);
				dataMap.put("restaurantList", restaurantList);
				Map<String, Object> returnMap = searchFormView.view(dataMap);
				
				int menu = (Integer) returnMap.get("menu");
				flag = (Boolean) returnMap.get("flag");
				if(!flag) {continue;}
				String searchType = (String)returnMap.get("searchType");
				String keyWord = (String)returnMap.get("keyword");
				
				switch(menu) {
				case 1:
					cri.setSearchType(searchType);
					cri.setKeyword(keyWord);
					restaurantList = restaurantService.getRestaurantList(cri);

					break;
				case 2:
					cri.setSearchType(searchType);
					cri.setKeyword(keyWord);
					restaurantList = restaurantService.getRestaurantList(cri);

					break;

				case 3:
				flag = false;
				break;
				}
			
			} catch (Exception e) {	
				e.printStackTrace();
			}
		}
		return null;
	}

}
