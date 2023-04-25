package com.java.controller.member;

import java.util.List;
import java.util.Map;

import com.java.attribute.Session;
import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.member.MemberVO;
import com.java.service.member.MemberService;
import com.java.service.member.MemberServiceImpl;
import com.java.views.View;
import com.java.views.member.LoginFormView;

public class SigninController extends Controller {

	private MemberVO currentUser; // 현재 로그인한 유저

	private View view = new LoginFormView();
	private MemberService memberService = new MemberServiceImpl();
	Map<String, Object> paramData = view.view(null);

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
				Map<String, Object> returnMap = view.view(dataMap);
				flag = (Boolean) returnMap.get("flag");
				if (!flag)
					break;

				int menu = (Integer) returnMap.get("menu");

				Session session = new Session();

				

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return null;
	}

}
