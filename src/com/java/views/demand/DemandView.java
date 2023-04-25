package com.java.views.demand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.attribute.Session;
import com.java.views.View;

public class DemandView extends View { //주문공급, 요청주문 선택메뉴 뷰
	
	{

		String menu = "================================\n";
		setMenu(menu);
	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		Session session = (Session) param.get("session");

		// main session 인 경우
		if (session.getAttribute("menu").equals("main")) {
			
			System.out.println("메뉴를 입력하세요");
			System.out.print("[1] 입고 발주 [2] 요청 공급 [3] 이전으로 \n");
			Scanner scann = new Scanner(System.in);
			int menu = scann.nextInt();
			scann.nextLine();

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("menu", menu);

			String message = "";
			boolean flag = true;
			switch (menu) {
			case 1:
				message = "입고 발주로 이동합니다.";
				break;
			case 2:
				message = "요청 공급으로 이동합니다.";
				break;
			case 3:
				message = "로그아웃 합니다.";
				flag = false;
				break;
			}
			dataMap.put("flag", flag);
			dataMap.put("menu", menu);

			System.out.println(message + " 엔터키를 치세요.");
			scann.nextLine();

			return dataMap;
		}
		return null;
	} 

}
