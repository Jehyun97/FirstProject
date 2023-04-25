package com.java.views.food;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.dto.food.FoodVO;
import com.java.views.View;

public class FoodSearchView extends View {

	{
		String menu = "====================== 식자재 검색 =========================\n";
		setMenu(menu);
	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		System.out.println(getMenu());
		System.out.println("======================식자재 리스트 ======================");
		System.out.println("식자재코드\t식자재명\t원산지\t알러지유무\t식자재구분\t보관방법\t단위");
		List<FoodVO> foodList = (List<FoodVO>) param.get("foodList");
		if (foodList != null)
			for (int i = 0; i < foodList.size(); i++) {
				FoodVO food = foodList.get(i);
				System.out.println(food.getFcode() + "\t" + food.getFname() + "\t" + food.getForigin() + "\t"
						+ food.getFallergy() + "\t" + food.getFcategory() + "\t" + food.getFmethod() + "\t"
						+ food.getFunit() + "\t");
			}
		System.out.println("-------------------- 메뉴를 입력하세요. --------------------");
		System.out.println("[1]식자재코드 검색   [2]식자재명 검색   [3]식자재분류 검색   [4]이전화면");
		Scanner scann = new Scanner(System.in);
		Map<String, Object> dataMap = new HashMap<String, Object>();

		int menu = scann.nextInt();
		scann.nextLine();

		dataMap.put("menu", menu);
		dataMap.put("foodList", foodList);
		boolean flag = true;
		String search = "";
		switch (menu) {
		case 1:
			System.out.println("검색하실 식자재의 코드를 입력해주세요.");
			search = "c";
			System.out.print("식자재코드: ");
			dataMap.put("keyword", scann.nextLine().toUpperCase());
			dataMap.put("flag", true);
			break;
		case 2:
			System.out.println("검색하실 식자재의 이름을 입력해주세요.");
			search = "n";
			System.out.print("식자재명: ");
			dataMap.put("keyword", scann.nextLine().toUpperCase());
			dataMap.put("flag", true);
			break;
		case 3:
			System.out.println("검색하실 식자재의 종류를 입력해주세요.");
			search = "t";
			System.out.print("식자재구분: ");
			dataMap.put("keyword", scann.nextLine().toUpperCase());
			dataMap.put("flag", true);
			break;
		case 4:
			System.out.println("이전화면으로 돌아갑니다.");
			dataMap.put("flag", false);
			break;
		}
		dataMap.put("flag", flag);
		dataMap.put("searchType", search);
		return dataMap;
	}

}
