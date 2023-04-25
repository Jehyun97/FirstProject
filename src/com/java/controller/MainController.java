package com.java.controller;

import java.util.List;
import java.util.Map;

import com.java.attribute.Session;
import com.java.command.Criteria;
import com.java.controller.food.FoodMainController;
import com.java.controller.member.MemberMainController;
import com.java.controller.restaurant.RestaurantMainController;
import com.java.controller.storage.StorageMainController;
import com.java.dto.member.MemberVO;
import com.java.service.member.MemberService;
import com.java.service.member.MemberServiceImpl;
import com.java.views.main.MainView;

public class MainController extends Controller {
	// 메인화면
	private MainView mainView = new MainView();
	private MemberVO currentUser; // 현재 로그인한 유저

	public MainController(MemberVO user) {
		this.currentUser = user;
	}

	// 회원서비스
	private MemberService memberService = new MemberServiceImpl();
	// 상품서비스
	// 주문서비스

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		boolean flag = true;

		while (flag) {
			// 회원 리스트 화면 출력
			Criteria cri = new Criteria();
			cri.setKeyword("");
			cri.setSearchType("");

			Map<String, Object> dataMap = paramMap;
			List<MemberVO> memberList = null;

			try {
				memberList = memberService.getMemberList(cri);

				dataMap.put("memberList", memberList);
				dataMap.put("member", currentUser);// 로그인한 유저 datamap에 저장
				Map<String, Object> returnMap = mainView.view(dataMap);
				flag = (Boolean) returnMap.get("flag");
				if (!flag)
					break;

				int menu = (Integer) returnMap.get("menu");

				Session session = new Session();

				switch (menu) {
				case 1: // 회원관리
					session.setAttribute("menu", "member"); // session을 멤버관리로 전환
					dataMap.put("session", session);
					MemberMainController memberMainController = new MemberMainController();
					returnMap = memberMainController.execute(dataMap);
					session.setAttribute("menu", "main");
//					flag = (Boolean)returMap.get("flag");					
					break;
				case 2: // 주문관리
					DemandController demandController = new DemandController();
					demandController.execute(dataMap);
					break;
				case 3: // 창고관리
					StorageMainController storageMainController = new StorageMainController();
					storageMainController.execute(dataMap);
					break;
				case 4: // 매장관리
					RestaurantMainController restaurantMainController = new RestaurantMainController();
					restaurantMainController.execute(dataMap);
					break;
				case 5: // 식자재관리
					FoodMainController foodMainController = new FoodMainController();
					foodMainController.execute(dataMap);
					break;
				case 6: // 로그아웃
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
