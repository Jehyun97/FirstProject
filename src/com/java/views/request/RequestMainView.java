package com.java.views.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.attribute.Session;
import com.java.views.View;

public class RequestMainView extends View {

//	요청공급 버튼을 누르면 나오는 메인화면

	{
		String menu = "************** 요청공급 *******************\n" + "[1] 식자재 요청 [2] 요청 조회  [3] 이전화면";
		setMenu(menu);

	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		Session session = (Session) param.get("session");
		System.out.println(getMenu());

		Scanner scann = new Scanner(System.in);
		Map<String, Object> dataMap = new HashMap<String, Object>();

		int menu = scann.nextInt();
		scann.nextLine();

		String message = "";
		boolean flag = true;
		switch (menu) {
		case 1: // 식자재 요청
			message = "식자재 요청 페이지로 이동합니다.";
			break;

		case 2: // 요청조회
			message = "요청 조회 페이지로 이동합니다.";
			break;

		case 3:
			// 종료
			dataMap.put("flag", false);
		}

		dataMap.put("flag", flag);
		dataMap.put("menu", menu);

		System.out.println(message + " 엔터키를 치세요.");
		scann.nextLine();

		return dataMap;

	}

}
