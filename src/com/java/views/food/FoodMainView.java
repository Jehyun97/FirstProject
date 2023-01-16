package com.java.views.food;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.views.View;

public class FoodMainView extends View {

	{
		String menu = "------------------------식자재 등록 ----------------------\n";
		setMenu(menu);
	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		System.out.println(getMenu());

		System.out.println();
		System.out.println("-------------------- 메뉴를 입력하세요. --------------------");
		System.out.println("\t[1]등록  \t[2]수정   \t[3]삭제  \t[4]새로고침");
		Scanner scann = new Scanner(System.in);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		int menu = scann.nextInt();
		scann.nextLine();

		dataMap.put("menu", menu);
		String message = "";
		boolean flag = true;
		switch (menu) {
		case 1:
			message = "식자재정보를 등록합니다.";
			break;
		case 2:
			message = "식자재 정보를 수정합니다.";
			break;
		case 3:
			message = "식자재정보를 삭제합니다.";
			break;
		case 4:
			message = "식자재정보를 삭제합니다.";
			break;
		}

		dataMap.put("flag", flag);
		dataMap.put("menu", menu);

		System.out.println(message + "엔터키를 입력하세요.");
		scann.nextLine();
		return dataMap;
	}

}