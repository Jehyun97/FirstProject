package com.java.controller.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.order.OrderListSearchVO;
import com.java.service.order.OrderLIstSearchServiceImpl;
import com.java.service.order.OrderListSearchService;
import com.java.views.View;
import com.java.views.order.OrderListSearchView;

public class OrderListSearchController extends Controller {

	private View view = new OrderListSearchView();
	private OrderListSearchService orderservice = new OrderLIstSearchServiceImpl();

	Scanner sc = new Scanner(System.in);

	Criteria cri = new Criteria();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		String KW = "";
		String ST = "";
		String mg = "";
		int returnMenu = 1;

		cri.setKeyword("");
		cri.setSearchType("");
		do {
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();

				List<OrderListSearchVO> orderList = orderservice.getOrderList(cri);
				dataMap.put("orderList", orderList);
				dataMap.put("returnMenu", returnMenu);
				Map<String, Object> paramData = view.view(dataMap);

				int menu = (Integer) paramData.get("menu");

				switch (menu) {
				case 1:
					KW = (String) paramData.get("KW");
					ST = (String) paramData.get("ST");
					cri.setKeyword(KW);
					cri.setSearchType(ST);
					returnMenu = 2;

					continue;
				case 2:
					flag = false;
					break;
				default:
					continue;

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (flag != false);

		return null;

	}

}
