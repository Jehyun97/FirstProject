package com.java.views.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.attribute.Session;
import com.java.dto.member.MemberVO;
import com.java.views.View;

public class MainView extends View {

	{

		String menu = "================================\n";
		setMenu(menu);
	}

	private MemberVO loginUser;

	@Override
	public Map<String, Object> view(Map<String, Object> param) {

		Session session = (Session) param.get("session");

		// main session 인 경우
		if (session.getAttribute("menu").equals("main")) {
			// loginUser = (MemberVO) session.getAttribute("loginUser");
			loginUser = (MemberVO) param.get("member");
			String preMenu = getMenu() + "\n" + loginUser.getName() + "님 반갑습니다.";

			System.out.println(preMenu);

			System.out.println("메뉴를 입력하세요");
			System.out.print("[1] 회원관리 [2] 주문관리 [3] 창고관리 [4] 매장관리 [5] 식자재 관리  [6]로그아웃 \n");
			Scanner scann = new Scanner(System.in);
			int menu = scann.nextInt();
			scann.nextLine();

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("menu", menu);

			String message = "";
			boolean flag = true;
			switch (menu) {
			case 1:
				message = "회원 관리로 이동합니다.";
				break;
			case 2:
				message = "주문관리로 이동합니다.";
				break;
			case 3:
				message = "창고관리로 이동합니다.";
				break;
			case 4:
				message = "매장관리로 이동합니다.";
				break;
			case 5:
				message = "식자재관리로 이동합니다.";
				break;
			case 6:
				message = "로그아웃 합니다.";
				flag = false;
				break;
			}
			dataMap.put("flag", flag);
			dataMap.put("menu", menu);

			System.out.println(message + " 엔터키를 치세요.");
			scann.nextLine();

			return dataMap;
		}
		if (session.getAttribute("menu").equals("member")) {

			System.out.println("메뉴를 입력하세요");
			System.out.print("[1] 전체 회원 조회 [2] 회원정보 변경 [3] 이전으로\n");
			Scanner scann = new Scanner(System.in);
			int menu = scann.nextInt();
			scann.nextLine();

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("menu", menu);

			String message = "";
			boolean flag = true;
			switch (menu) {
			case 1:
				message = "전체 회원을 조회합니다.";
				break;
			case 2:
				message = "회원정보 변경 메뉴입니다.";
				break;
			case 3:
				message = "이전 화면으로 돌아갑니다.";
				flag = false;
				break;
			}
			dataMap.put("flag", flag);
			dataMap.put("menu", menu);

			return dataMap;
		}
		return null;
	}

}
