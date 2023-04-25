package com.java.controller.food;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.food.FoodVO;
import com.java.service.food.FoodService;
import com.java.service.food.FoodServiceImpl;
import com.java.views.food.FoodMainView;

public class FoodMainController extends Controller {

	private FoodMainView mainView = new FoodMainView();
	
	private FoodService foodService = new FoodServiceImpl();
	

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		 
		boolean flag = true;
		
		while(flag) {
			Criteria cri = new Criteria();
			cri.setKeyword("");
			cri.setSearchType("");
			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			List<FoodVO> foodList = null;
			
			try {
				foodList = foodService.getFoodList(cri);
				dataMap.put("foodList", foodList);
				Map<String, Object> returnMap = mainView.view(dataMap);
				flag = (Boolean) returnMap.get("flag");
				if(!flag) continue;
				
				int menu = (Integer) returnMap.get("menu");
				
				switch(menu) {
				case 1:
					//등록 
					FoodListController listController = new FoodListController();  
					listController.execute(dataMap);
					break;
				case 2:
					//수정
					FoodUpdateController detailController = new FoodUpdateController();
					detailController.execute(dataMap);
					break;
				case 3:
					//조회
					FoodSearchController searchController = new FoodSearchController();
					searchController.execute(dataMap);
					break;
				case 4:
					//메인
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
