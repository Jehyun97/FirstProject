package com.java.views.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.views.View;

public class StorageMainView extends View {

	{
		String menu = "============================================================\n"
				+ " [1] 창고입출고 내역 조회   [2] 창고 정보 수정  [3] 전체 창고 식재료 수량 보기   [4] 뒤로가기 ";

		setMenu(menu);
	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {

		System.out.println(getMenu());

		Scanner scann = new Scanner(System.in);
		int menu = scann.nextInt();
		scann.nextLine();

		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("menu", menu);
		boolean flag = true;
		String message = "";
		switch (menu) {
		case 1:
			message = "창고입출고 내역으로 이동합니다.";
			break;
		case 2:
			message = "창고 정보 수정으로 이동합니다.";
			break;
		case 3:
			message = "전체 창고 식재료 수량 보기로 이동합니다.";
			break;
		case 4:
			message = "이전메뉴로 이동합니다.";
			flag = false;
			break;
		}
		dataMap.put("flag", flag);
		dataMap.put("menu", menu);

		System.out.println(message + " 엔터키를 치세요.");
		scann.nextLine();

		return dataMap;

	}

}
