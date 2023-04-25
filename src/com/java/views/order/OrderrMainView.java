package com.java.views.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.dto.order.OrderListSearchVO;
import com.java.views.View;

public class OrderrMainView extends View {

	{
		String menu = "=========================주문서관리=========================\n"
				+"[1]상세 검색 [2]주문서 등록 [3]주문서 수정 [4]주문서 삭제 [5]메인화면"
		        +"\n"
		        +"\n";
		setMenu(menu);
	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		String premenu = getMenu();
		System.out.println("=========================주문서============================");
		List<OrderListSearchVO> orderList = (List<OrderListSearchVO>) param.get("orderList");
		System.out.println("[주문일자]\t\t[주문번호]\t\t[식자재명]\t\t[수량]\t[도매업체명]\t[창고번호]");
		if (orderList != null)
			for (int i = 0; i < orderList.size(); i++) {
				OrderListSearchVO order = orderList.get(i);
				System.out.println(order);
			}
		System.out.println(premenu);
		System.out.print("메뉴를 입력하세요: ");
		Scanner scann = new Scanner(System.in);
		int menu = scann.nextInt();
		scann.nextLine();

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("menu", menu);

		String message = "";
		boolean flag = true;
		switch (menu) {
		case 1:
			dataMap.put("menu", menu);
			break;
		case 2:
			dataMap.put("menu", menu);

			break;
		case 3:
			dataMap.put("menu", menu);
			break;
		case 4:
			dataMap.put("menu", menu);
			break;
		case 5:
			flag = false;
			break;
		}

		dataMap.put("flag", flag);
		dataMap.put("menu", menu);

		return dataMap;

	}

}
