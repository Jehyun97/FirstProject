package com.java.views.restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.dto.restaurant.RestaurantVO;
import com.java.views.View;


public class RestaurantMainView extends View{
	
	{
		String menu = "------------------------매장 등록 ----------------------\n";
		setMenu(menu);
	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		System.out.println(getMenu());
		
		System.out.println("=====================최근 등록된 매장 ==================== ");
		System.out.println("매장코드\t매장명\t매장연락처");
		List<RestaurantVO> restaurantList = (List<RestaurantVO>)param.get("restaurantList");
		if(restaurantList != null) for (int i=0; i<restaurantList.size();i++) {
			RestaurantVO restaurant = restaurantList.get(i);
			System.out.println(restaurant.getRcode()+"\t"+restaurant.getRname()+"\t"+restaurant.getRphone()+"\t");
		}

		System.out.println();
		System.out.println("-------------------- 메뉴를 입력하세요. --------------------");
		System.out.println("      [1]등록    [2]수정    [3]조회    [4]이전화면");
		Scanner scann = new Scanner(System.in);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int menu = scann.nextInt();
		scann.nextLine();

		dataMap.put("menu", menu);
		String message = "";
		boolean flag = true;
		switch (menu) {
		case 1:
			message = "매장정보를 등록합니다.";
			break;
		case 2:
			message = "매장정보를 수정합니다.";
			break;
		case 3:
			message = "매장 정보를 조회합니다.";
			break;
		case 4:
			message = "이전화면으로 돌아갑니다.";
			flag=false;
			break;
		}
		
		dataMap.put("flag", flag);
		dataMap.put("menu", menu);
		
		System.out.println(message+ "엔터키를 입력하세요.");
		scann.nextLine();		
		return dataMap;
	}

}
