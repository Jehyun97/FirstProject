package com.java.views.restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.dto.restaurant.RestaurantVO;
import com.java.views.View;

public class RestaurantSearchView extends View {

	{
		String menu = "====================== 매장 검색 =========================\n";
		setMenu(menu);
	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		System.out.println(getMenu());
		System.out.println("======================매장 리스트 ======================");
		System.out.println("매장코드\t매장명\t매장연락처");
		List<RestaurantVO> restaurantList = (List<RestaurantVO>) param.get("restaurantList");
		if (restaurantList != null)
			for (int i = 0; i < restaurantList.size(); i++) {
				RestaurantVO restaurant = restaurantList.get(i);
				System.out.println(
						restaurant.getRcode() + "\t" + restaurant.getRname() + "\t" + restaurant.getRphone() + "\t");
			}
		System.out.println("-------------------- 메뉴를 입력하세요. --------------------");
		System.out.println("\t  [1]매장코드 검색    [2]매장명 검색    [3]이전화면");
		Scanner scann = new Scanner(System.in);
		Map<String, Object> dataMap = new HashMap<String, Object>();

		int menu = scann.nextInt();
		scann.nextLine();

		dataMap.put("menu", menu);
		dataMap.put("restaurantList", restaurantList);
		boolean flag = true;
		String search = "";
		switch (menu) {
		case 1:
			System.out.println("검색하실 매장의 코드를 입력해주세요.");
			search = "c";
			System.out.print("매장코드: ");
			dataMap.put("keyword", scann.nextLine().toUpperCase());
			dataMap.put("flag", true);
			break;
		case 2:
			System.out.println("검색하실 매장의 이름을 입력해주세요.");
			search = "n";
			System.out.print("매장명: ");
			dataMap.put("keyword", scann.nextLine());
			dataMap.put("flag", true);
			break;
		case 3:
			System.out.println("이전화면으로 돌아갑니다.");
			dataMap.put("flag", false);
			break;
		}
		dataMap.put("searchType", search);
		return dataMap;
	}

}
