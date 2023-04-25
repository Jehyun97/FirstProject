package com.java.views.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.views.View;

public class OrderRegistView extends View {
	{
		String menu = "===========================주문서 등록==========================";
		setMenu(menu);
	}
	Scanner sc = new Scanner(System.in);

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean flag = true;

		String menu1 = getMenu();
		System.out.println(menu1);
		System.out.print("입고 코드를 입력하세요: \n");
		String Ocode = sc.nextLine().toUpperCase();
		System.out.print("식자재 코드를 입력하세요: \n");
		String Fcode = sc.nextLine().toUpperCase();
		System.out.print("날짜를 입력하세요: \n");
		String Odate = sc.nextLine();
		System.out.print("수량을 입력하세요: \n");
		int Oqty = sc.nextInt();
		sc.nextLine();
		System.out.print("창고번호를 입력하세요: \n");
		String Snum = sc.nextLine().toUpperCase();
		dataMap.put("Ocode", Ocode);
		dataMap.put("Fcode", Fcode);
		dataMap.put("Odate", Odate);
		dataMap.put("Oqty", Oqty);
		dataMap.put("Snum", Snum);

		System.out.println("등록되었습니다");
		System.out.println("======================================================");
		System.out.println("===================창고에 등록하시겠습니까?===================");
		System.out.println("========================[Y/N]=========================");

		String addmenu = sc.nextLine().toUpperCase();
		dataMap.put("menu", addmenu);

		switch (addmenu) {

		case "Y":
			flag = true;
			System.out.println("창고입출고 번호를 입력하세요 :  ");
			dataMap.put("sd_num", sc.nextLine().toUpperCase());
			System.out.println("섹션을 입력하세요 :   ");
			dataMap.put("section", sc.nextLine());
			System.out.println("적정재고를 입력하세요 : ");
			dataMap.put("sdstandard", sc.nextInt());
			System.out.println("등록 되었습니다.");
			break;

		case "N":
			flag = false;
			break;
		}
		dataMap.put("addmenu", addmenu);
		dataMap.put("flag", flag);

		///////////////////////////////////////////
		System.out.print("다른 주문서 등록 [1] 이전화면 [2]");
		int menu = sc.nextInt();
		sc.nextLine();
		dataMap.put("menu", menu);
		switch (menu) {
		case 1:
			flag=true;
			break;
		case 2:
			flag = false;
			break;
		}
		dataMap.put("flag", flag);
		dataMap.put("menu", menu);

		return dataMap;

	}

}
