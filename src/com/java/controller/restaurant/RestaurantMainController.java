package com.java.controller.restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.restaurant.RestaurantVO;
import com.java.service.restaurant.RestaurantService;
import com.java.service.restaurant.RestaurantServiceImpl;
import com.java.views.restaurant.RestaurantMainView;


public class RestaurantMainController extends Controller {

	private RestaurantMainView mainView = new RestaurantMainView();

	private RestaurantService restaurantService = new RestaurantServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		boolean flag = true;

		while (flag) {
			Criteria cri = new Criteria();
			cri.setKeyword("");
			cri.setSearchType("");

			Map<String, Object> dataMap = new HashMap<String, Object>();
			List<RestaurantVO> restaurantList = null;

			try {
				restaurantList = restaurantService.getRestaurantList(cri);
				dataMap.put("restaurantList", restaurantList);
				Map<String, Object> returnMap = mainView.view(dataMap);
				flag = (Boolean) returnMap.get("flag");
				if (!flag)
					continue;

				int menu = (Integer) returnMap.get("menu");

				switch (menu) {
				case 1:
					// 등록
					RestaurantListController listController = new RestaurantListController();
					listController.execute(dataMap);
					break;
				case 2:
					// 수정
					RestaurantUpdateController detailController = new RestaurantUpdateController();
					detailController.execute(dataMap);
					break;
				case 3:
					// 조회
					RestaurantSearchController searchController = new RestaurantSearchController();
					searchController.execute(dataMap);
					break;
				case 4:
					// 메인
					flag = false;
					break;
				}

//				mainView.view(dataMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

}
