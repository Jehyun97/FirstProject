package com.java.views.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.dto.order.OrderVO;
import com.java.views.View;

public class OrderModifyView extends View {
	{
		String menu = "=========================주문서 수정=========================";
		setMenu(menu);
	}
	Scanner sc = new Scanner(System.in);

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean flag = true;
		String menu2 = getMenu();
		System.out.println(menu2);
		List<OrderVO> orderlist = (List<OrderVO>) param.get("OcodebyList");
		if (orderlist != null)
			for (int i = 0; i < orderlist.size(); i++) {
				OrderVO order = orderlist.get(i);
				System.out.println(order);
			}

		System.out.println("=======================================");
		System.out.println("    수정하실 주문서의 주문번호를 입력하세요      ");
		System.out.println("=======================================");
		System.out.print  ("        주문번호:");
		dataMap.put("Ocode", sc.nextLine().toUpperCase());
		System.out.println("=======================================");
		System.out.println("   [F]식자재 코드   [Q]수량  [S]창고 번호 ");
		System.out.println("=======================================");
		System.out.print  ("      입력:");
		String menu;
		menu = sc.nextLine().toUpperCase();
		switch (menu) {
		case "F":
			System.out.println("=======================================");
			System.out.print(       "입력:");
			dataMap.put("Fcode", sc.nextLine().toUpperCase());
			dataMap.put("menu", menu);

			break;
		case "Q":
			System.out.println("=======================================");
			System.out.print(       "입력:");
			dataMap.put("Oqty", sc.nextInt());
			sc.nextLine();
			dataMap.put("menu", menu);
			break;
		case "S":
			System.out.println("=======================================");
			System.out.print(       "입력:");
			dataMap.put("Snum", sc.nextLine().toUpperCase());
			dataMap.put("menu", menu);
			break;
		}
		System.out.println("=======================================");
		System.out.println("               수정되었습니다              ");
		System.out.println("=======================================");
		System.out.println("=======================================");
		System.out.println("          [1]추가수정 [2]이전화면");
		System.out.println("=======================================");
		System.out.print ("       입력:");
		int m = sc.nextInt();
		sc.nextLine();
		if (m == 1) {
			flag = true;
			dataMap.put("flag", flag);
		} else {
			flag = false;
			dataMap.put("flag", flag);
		}

		return dataMap;
	}

}
