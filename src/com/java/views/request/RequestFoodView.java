package com.java.views.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.views.View;

public class RequestFoodView extends View {

	{
		String menu = "************** 식자재 요청 *******************\n";

		setMenu(menu);

	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {

		Scanner scann = new Scanner(System.in);
		Map<String, Object> dataMap = new HashMap<String, Object>();

		System.out.print("식자재 코드 : ");
		dataMap.put("f_code", scann.nextLine());
		System.out.print("식자재 수량 : ");
		dataMap.put("re_qty", scann.nextLine());
		return null;
	}

}
