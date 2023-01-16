package com.java.controller.food;

import java.util.Map;

import com.java.controller.Controller;
import com.java.dto.food.FoodVO;
import com.java.service.food.FoodService;
import com.java.service.food.FoodServiceImpl;
import com.java.views.food.FoodDeleteView;

public class FoodDeleteController extends Controller {

	private FoodDeleteView deleteFormView = new FoodDeleteView();
	private FoodService foodService = new FoodServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;

		while (flag) {
			Map<String, Object> paramData = deleteFormView.view(null);

//			flag = (Boolean) paramData.get("flag");

			if (!flag)
				continue;

			String fcode = (String) paramData.get("f_code");

			try {
				FoodVO food = foodService.getFood(fcode);
				if (paramMap != null) {
					if (fcode.equals(food.getFcode())) {
						foodService.remove(fcode);
					}
				} else {
					System.out.println("계속하시겠습니까?");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}
}