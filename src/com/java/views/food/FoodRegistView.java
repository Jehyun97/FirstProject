package com.java.views.food;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.service.food.FoodService;
import com.java.service.food.FoodServiceImpl;
import com.java.views.View;

public class FoodRegistView extends View {

	{
		String menu = "====================== 식자재 등록 =========================\n" + "[1]등록   [2]이전화면";
		setMenu(menu);
	}

	private FoodService foodService = new FoodServiceImpl();

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		System.out.println(getMenu());

		Scanner scann = new Scanner(System.in);
		Map<String, Object> dataMap = new HashMap<String, Object>();

		int menu = scann.nextInt();
		scann.nextLine();

		boolean flag = true;
		switch (menu) {
		case 1:
			System.out.print("식자재코드: ");
			dataMap.put("f_code", scann.nextLine().toUpperCase());
			System.out.print("식자재이름: ");
			dataMap.put("f_name", scann.nextLine());
			System.out.print("원산지: ");
			dataMap.put("f_origin", scann.nextLine());
			System.out.print("알러지유무: ");
			dataMap.put("f_allergy", scann.nextLine().toUpperCase());
			System.out.print("식자재구분: ");
			dataMap.put("f_category", scann.nextLine());
			System.out.print("보관방법: ");
			dataMap.put("f_method", scann.nextLine());
			System.out.print("단위: ");
			dataMap.put("f_unit", scann.nextLine().toUpperCase());
			dataMap.put("flag", true);
			break;

		case 2:
			System.out.println("이전화면으로 돌아갑니다.");
			dataMap.put("flag", false);
		}

		return dataMap;
	}

}
