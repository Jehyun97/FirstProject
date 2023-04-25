package com.java.controller.member;

import java.util.Map;

import com.java.attribute.Session;
import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.service.member.MemberService;
import com.java.service.member.MemberServiceImpl;
import com.java.views.main.MainView;

public class MemberMainController extends Controller {

	Session session = new Session();
	// 메인화면
	private MainView mainView = new MainView();
	// 회원서비스
//	private MemberService memberService = new MemberServiceImpl();
	// 상품서비스
	// 주문서비스

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		boolean flag = true;

		while (flag) {
			Criteria cri = new Criteria();
			cri.setKeyword("");
			cri.setSearchType("");

			Map<String, Object> dataMap = paramMap;

			Map<String, Object> returnMap = mainView.view(dataMap);

			flag = (Boolean) returnMap.get("flag");

			if (!flag)
				// 종료 메뉴 선택 안한경우 계속
				break;

			try {

				flag = (Boolean) returnMap.get("flag");
				if (!flag)

					break;

				int menu = (Integer) returnMap.get("menu");

				switch (menu) {
				case 1: // 회원정보 조회
//					System.out.println("번호\t이름\t전화번호");
//					memberList = memberService.getMemberList(cri);
//					for (int i = 0; i < memberList.size(); i++) {
//						MemberVO mem = memberList.get(i);
//						System.out.println((i + 1) + "\t" + mem.getName() + "\t" + mem.getPhone());
//					}
					MemberListController memberViewController = new MemberListController();
					memberViewController.execute(dataMap);
					break;

				case 2: // 회원정보 변경
					UpdateMemberController updateMemberController = new UpdateMemberController();
					updateMemberController.execute(dataMap);
					break;

				case 3: // 로그아웃
					session = Session.getSession();
					session.setAttribute("loginUser", null);
					flag = false;
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return null;
	}

}
