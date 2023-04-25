package com.java.views.food;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.dto.food.FoodVO;
import com.java.views.View;

public class FoodMainView extends View {

	{
		String menu = "======================== 식자재 등록 ========================\n";
		setMenu(menu);
	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		System.out.println(getMenu());

		System.out.println("===================최근 등록된 식자재 리스트 ===================");
		System.out.println("식자재코드\t식자재명\t원산지\t알러지유무\t식자재구분\t보관방법\t단위");
		List<FoodVO> foodList = (List<FoodVO>) param.get("foodList");
		if (foodList != null)
			for (int i = 0; i < 5; i++) {
				FoodVO food = foodList.get(i);
				System.out.println(food.getFcode() + "\t" + food.getFname() + "\t" + food.getForigin() + "\t"
						+ food.getFallergy() + "\t" + food.getFcategory() + "\t" + food.getFmethod() + "\t"
						+ food.getFunit() + "\t");
			}
		System.out.println("======================== 메뉴를 입력하세요 ========================");
		System.out.println("\t[1]등록    [2]수정    [3]조회    [4]이전화면으로");
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
			message = "식자재정보를 조회합니다.";
			break;
		case 4:
			message = "이전화면으로 돌아갑니다.";
			break;
		}

		dataMap.put("flag", flag);
		dataMap.put("menu", menu);

		System.out.println(message + "엔터키를 입력하세요.");
		scann.nextLine();
		return dataMap;
	}

}
