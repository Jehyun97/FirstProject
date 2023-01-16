package com.java.views.food;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.service.food.FoodService;
import com.java.service.food.FoodServiceImpl;
import com.java.views.View;

public class FoodDeleteView extends View {
	{
		String menu = "====================== 식자재 삭제 =========================\n" + "[1]삭제   [2]이전화면";
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

		switch (menu) {
		case 1:
			System.out.println("삭제할 식자재의 코드를 입력해주세요.");
			System.out.println("식자재코드: ");
			dataMap.put("f_code", scann.nextLine().toUpperCase());
			break;
		case 2:
			break;
		}
		return dataMap;
	}

}