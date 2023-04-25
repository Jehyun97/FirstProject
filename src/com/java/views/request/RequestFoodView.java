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

		System.out.print("요청서 번호 : ");
		dataMap.put("re_num", scann.nextLine());
		System.out.print("매장 코드 : ");
		dataMap.put("r_code", scann.nextLine().toUpperCase());
		System.out.print("식자재 코드 : ");
		dataMap.put("f_code", scann.nextLine().toUpperCase());
		System.out.print("요청날짜 : ");
		dataMap.put("re_date", scann.nextLine());
		System.out.print("식자재 수량 : ");
		dataMap.put("re_qty", scann.nextInt());
		scann.nextLine();
		System.out.println("등록되었습니다");

		boolean flag = true;
		dataMap.put("flag", flag);

		System.out.println("======================================================");
		System.out.println("==================창고에 등록하시겠습니까?====================");
		System.out.println("========================[Y/N]=========================");

		String menu = scann.nextLine().toUpperCase();

		switch (menu) {
		case "Y":

			flag = true;
			System.out.println("창고 번호를 입력하세요 :  ");
			dataMap.put("s_num", scann.nextLine().toUpperCase());
			System.out.println("창고상세 번호을 입력하세요 :   ");
			dataMap.put("sd_num", scann.nextLine());
			System.out.println("등록되었습니다.");

		case "N":
			flag = false;

		}
		dataMap.put("menu",menu);
		dataMap.put("flag", flag);
		return dataMap;

	}

}