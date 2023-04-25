package com.java.controller.restaurant;

import java.util.Map;

import com.java.controller.Controller;
import com.java.dto.restaurant.RestaurantVO;
import com.java.service.restaurant.RestaurantService;
import com.java.service.restaurant.RestaurantServiceImpl;
import com.java.views.restaurant.RestaurantUpdateView;


public class RestaurantUpdateController extends Controller{
	
	private RestaurantUpdateView modifyFormView = new RestaurantUpdateView();
	private RestaurantService restaurantService = new RestaurantServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		
		while (flag) {
			Map<String, Object> paramData = modifyFormView.view(null);

			flag = (Boolean) paramData.get("flag");
			if (!flag)
				continue;
			
			RestaurantVO restaurantVO = new RestaurantVO();
			restaurantVO.setRcode((String) paramData.get("r_code"));
			restaurantVO.setRname((String) paramData.get("r_name"));
			restaurantVO.setRphone((String) paramData.get("r_phone"));
			
		
			try {
				restaurantService.modify(restaurantVO);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}
}