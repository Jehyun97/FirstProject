package com.java.controller.restaurant;


import java.util.Map;


import com.java.controller.Controller;
import com.java.dto.restaurant.RestaurantVO;
import com.java.service.restaurant.RestaurantService;
import com.java.service.restaurant.RestaurantServiceImpl;
import com.java.views.restaurant.RestaurantListView;

public class RestaurantListController extends Controller {


	private RestaurantListView registFormView = new RestaurantListView();
	private RestaurantService restaurantService = new RestaurantServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		
		while (flag) {
			Map<String, Object> paramData = registFormView.view(null);

			flag = (Boolean) paramData.get("flag");
			if (!flag)
				continue;
			
			RestaurantVO restaurantVO = new RestaurantVO();
			restaurantVO.setRcode((String) paramData.get("r_code"));
			restaurantVO.setRname((String) paramData.get("r_name"));
			restaurantVO.setRphone((String) paramData.get("r_phone"));
		
			try {
				restaurantService.regist(restaurantVO);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}
}
