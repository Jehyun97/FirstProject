package com.java.controller;

import java.util.Map;

import com.java.attribute.Session;
import com.java.command.Criteria;
import com.java.controller.order.OrderMainController;
import com.java.controller.request.RequestMainController;
import com.java.views.demand.DemandView;

public class DemandController extends Controller {

	private DemandView demandView = new DemandView();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		boolean flag = true;

		Criteria cri = new Criteria();
		cri.setKeyword("");
		cri.setSearchType("");

		Map<String, Object> dataMap = paramMap;

		Map<String, Object> returnMap = demandView.view(dataMap);
		flag = (Boolean) returnMap.get("flag");
		

		int menu = (Integer) returnMap.get("menu");

		Session session = new Session();

		switch (menu) {
		case 1: // 주문발주
			OrderMainController orderMainController = new OrderMainController();
			orderMainController.execute(dataMap);					
			break;
		case 2: // 요청공급
			RequestMainController requestMainController = new RequestMainController();
			requestMainController.execute(dataMap);
			break;
		case 3: // 이전으로
			flag = false;
			break;

		}
		
		return null;
		
	}

}
