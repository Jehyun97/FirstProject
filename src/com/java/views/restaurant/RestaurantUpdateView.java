package com.java.views.restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.views.View;

public class RestaurantUpdateView extends View{
	
	{
		String menu = "====================== 매장 수정 =========================\n"
				+"\t    [1]시작하기    \t\t[2]이전화면";
		setMenu(menu);
	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		System.out.println(getMenu());
		
		Scanner scann = new Scanner(System.in);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		int menu = scann.nextInt();
		scann.nextLine();
		
		switch(menu) {
		case 1: 			
			System.out.println("수정하실 매장의 코드를 입력해주세요.");
			System.out.println("매장코드: ");
			dataMap.put("r_code", scann.nextLine().toUpperCase());
			System.out.println("매장명: ");
			dataMap.put("r_name", scann.nextLine());
			System.out.println("매장연락처: ");
			dataMap.put("r_phone", scann.nextLine());
			dataMap.put("flag", true);
			break;
			
		case 2:
			System.out.println("이전화면으로 돌아갑니다.");
			 dataMap.put("flag", false);
		}
		return dataMap;
	}

}