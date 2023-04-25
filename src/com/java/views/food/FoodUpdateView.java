package com.java.views.food;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.views.View;

public class FoodUpdateView extends View{
	
	{
		String menu = "====================== 식자재 수정 =========================\n"
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
			System.out.println("수정하실 식자재의 코드를 입력해주세요.");
			System.out.println("식자재코드: ");
			dataMap.put("f_code", scann.nextLine().toUpperCase());
			System.out.println("식자재명: ");
			dataMap.put("f_name", scann.nextLine());
			System.out.println("원산지: ");
			dataMap.put("f_origin", scann.nextLine());
			System.out.println("알러지유발유무: ");
			dataMap.put("f_allergy", scann.nextLine().toUpperCase());
			System.out.println("식자재구분: ");
			dataMap.put("f_category", scann.nextLine());
			System.out.println("보관방법: ");
			dataMap.put("f_method", scann.nextLine());
			System.out.println("단위: ");
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