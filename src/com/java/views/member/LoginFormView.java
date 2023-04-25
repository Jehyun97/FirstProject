package com.java.views.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.views.View;

public class LoginFormView extends View {
	{
		String menu = "************** 시작화면 *******************\n" + "[1] 로그인 [2] 회원가입  [3] 종료";

		setMenu(menu);

	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		System.out.println(getMenu());

		Scanner scann = new Scanner(System.in);
		Map<String, Object> dataMap = new HashMap<String, Object>();

		int menu = scann.nextInt();
		scann.nextLine();

		switch (menu) {
		case 1:
			// 로그인 메뉴
			System.out.print("아이디 : ");
			dataMap.put("id", scann.nextLine());
			System.out.print("패스워드 : ");
			dataMap.put("pwd", scann.nextLine());
			dataMap.put("flag", true);
			dataMap.put("menu", menu);
			break;

		case 2:
			// 회원가입 메뉴
			System.out.print("아이디 : ");
			dataMap.put("id", scann.nextLine());
//			System.out.print("패스워드 : ");
//			dataMap.put("pwd", scann.nextLine());
//			System.out.print("이름 : ");
//			dataMap.put("name", scann.nextLine());
//			System.out.print("전화번호 : ");
//			dataMap.put("phone", scann.nextLine());

			// 회원가입은 SignupController로 진행 되도록 변경
			dataMap.put("flag", true);
			dataMap.put("menu", menu);
			break;

		case 3:
			// 종료
			dataMap.put("flag", false);
		}

		return dataMap;

	}

}
