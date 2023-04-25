package com.java.views.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.dto.order.OrderVO;
import com.java.views.View;

public class OrderRemoveView extends View {
	{
		String menu = "=========================주문서 삭제=========================";
		setMenu(menu);
	}

	Scanner sc = new Scanner(System.in);
	boolean flag;

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		String menu2 = getMenu();
		System.out.println(menu2);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		System.out.println("[주문번호]\t\t[식자재번호]\t[창고번호]\t\t[주문일자]\t\t[수량]");
		List<OrderVO> orderlist = (List<OrderVO>) param.get("orderlist");
		if (orderlist != null)
			for (int i = 0; i < orderlist.size(); i++) {
				OrderVO order = orderlist.get(i);
				System.out.println(order);

			}
		System.out.print("삭제하실 주문서의 입고번호를 입력하세요:");
		dataMap.put("Ocode", sc.nextLine().toUpperCase());
		System.out.println("삭제되었습니다");
		System.out.println("[1]추가 삭제 [2]이전화면");
		int menu = sc.nextInt();
		sc.nextLine();
		if (menu == 1) {
			flag = true;
			dataMap.put("flag", flag);
		} else {
			flag = false;
			dataMap.put("flag", flag);
		}

		return dataMap;
	}

}
