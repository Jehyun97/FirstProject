package com.java.controller.food;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.attribute.Session;
import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.food.FoodVO;
import com.java.service.food.FoodService;
import com.java.service.food.FoodServiceImpl;
import com.java.views.main.MainView;

public class FoodMainController extends Controller {

	// 등록컨틀롤러
//	private ListController listController = new ListController();
	// 삭제컨틀롤러
	// 수정컨틀롤러

	// 메인화면
	private MainView mainView = new MainView();
	// 등록화면
//	private RegistFormView registFormView = new RegistFormView();

	// 식자재서비스
	private FoodService foodService = new FoodServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		boolean flag = true;

		while (flag) {

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
				if (!flag)
					continue;

				int menu = (Integer) returnMap.get("menu");

				switch (menu) {
				case 1:
					// 등록
					FoodListController listController = new FoodListController();
					listController.execute(null);
					break;
				case 2:
					// 수정
					FoodDetailController detailController = new FoodDetailController();
					detailController.execute(null);
					break;
				case 3:
					// 삭제
					FoodDeleteController deleteController = new FoodDeleteController();
					deleteController.execute(null);
					break;
				case 4:
					// 메인
					Session session = Session.getSession();
					session.setAttribute("registFood", null);
					flag = false;
					break;
				}

				mainView.view(dataMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

}