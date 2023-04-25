package com.java.controller.food;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.food.FoodVO;
import com.java.service.food.FoodService;
import com.java.service.food.FoodServiceImpl;
import com.java.views.food.FoodSearchView;

public class FoodSearchController extends Controller {

	private FoodSearchView searchFormView = new FoodSearchView();
	private FoodService foodService = new FoodServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		Criteria cri = new Criteria();
		cri.setSearchType("");
		cri.setKeyword("");

		while (flag) {

			Map<String, Object> dataMap = new HashMap<String, Object>();

			List<FoodVO> foodList = null;

			try {
				foodList = foodService.getFoodList(cri);
				dataMap.put("foodList", foodList);
				Map<String, Object> returnMap = searchFormView.view(dataMap);

				int menu = (Integer) returnMap.get("menu");
				flag = (Boolean) returnMap.get("flag");
				if (!flag) {
					continue;
				}
				String searchType = (String) returnMap.get("searchType");
				String keyWord = (String) returnMap.get("keyword");

				switch (menu) {
				case 1:
					cri.setSearchType(searchType);
					cri.setKeyword(keyWord);
					foodList = foodService.getFoodList(cri);
//					System.out.println(foodList);
					break;
				case 2:
					cri.setSearchType(searchType);
					cri.setKeyword(keyWord);
					foodList = foodService.getFoodList(cri);
//					System.out.println(foodList);
					break;
				case 3:
					cri.setSearchType(searchType);
					cri.setKeyword(keyWord);
					foodList = foodService.getFoodList(cri);
//					System.out.println(foodList);
					break;
				case 4:
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
