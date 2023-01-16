package com.java.controller.food;

import java.util.Map;

import com.java.controller.Controller;
import com.java.dto.food.FoodVO;
import com.java.service.food.FoodService;
import com.java.service.food.FoodServiceImpl;
import com.java.views.food.FoodRegistView;

public class FoodListController extends Controller {

	private FoodRegistView registFormView = new FoodRegistView();
	private FoodService foodService = new FoodServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;

		while (flag) {
			Map<String, Object> paramData = registFormView.view(null);

			flag = (Boolean) paramData.get("flag");
			if (!flag)
				continue;

			FoodVO foodVO = new FoodVO();
			foodVO.setFcode((String) paramData.get("f_code"));
			foodVO.setFname((String) paramData.get("f_name"));
			foodVO.setForigin((String) paramData.get("f_origin"));
			foodVO.setFallergy((String) paramData.get("f_allergy"));
			foodVO.setFcategory((String) paramData.get("f_category"));
			foodVO.setFmethod((String) paramData.get("f_method"));
			foodVO.setFunit((String) paramData.get("f_unit"));

			try {
				foodService.regist(foodVO);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}
}

// productService : service
// product regist view : registView
// product list controller : listController
// product mofigy view : registView
// product detail controller : detailController

/*
 * 
 * Map<String,Object> dataMap = registview.view(null); ProductVO product =
 * (ProductVO)dataMap.get("product");
 * 
 * service.regist(product);
 * 
 * 
 * listController.execute(null);
 * 
 */