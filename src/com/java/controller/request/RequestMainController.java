package com.java.controller.request;

import java.util.List;
import java.util.Map;

import com.java.attribute.Session;
import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.request.RequestVO;
import com.java.service.request.RequestService;
import com.java.service.request.RequestServiceImpl;
import com.java.views.request.RequestMainView;

public class RequestMainController extends Controller {

	private RequestMainView requestMainView = new RequestMainView();
	private RequestService requestService = new RequestServiceImpl();


	// 회원서비스
	// 상품서비스
	// 주문서비스

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		boolean flag = true;

		while (flag) {
			Criteria cri = new Criteria();
			cri.setKeyword("");
			cri.setSearchType("");

			
			Map<String, Object> foodMap = paramMap;
			Map<String, Object> dataMap = paramMap;
			List<RequestVO> requestList = null;
			List<RequestVO> foodList = null; //FoodVO 필요

			try {
				requestList = requestService.getRequestList(cri);

				foodMap.put("foodList", foodList);
				dataMap.put("requestList", requestList);
				Map<String, Object> returnMap = requestMainView.view(dataMap);
				flag = (Boolean) returnMap.get("flag");
				if (!flag)
					break;

				int menu = (Integer) returnMap.get("menu");

				Session session = new Session();

				switch (menu) {

				case 1: // 식자재 요청
					RequestFoodController requestFoodController = new RequestFoodController();
					returnMap = requestFoodController.execute(dataMap);
					break;
				case 2: // 요청조회
					RequestListController requestListController = new RequestListController();
					returnMap = requestListController.execute(dataMap);
					break;
				case 3: // 이전으로
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
