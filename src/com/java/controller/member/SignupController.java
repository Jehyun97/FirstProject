package com.java.controller.member;

import java.util.Map;

import com.java.controller.Controller;
import com.java.dto.member.MemberVO;
import com.java.service.member.MemberService;
import com.java.service.member.MemberServiceImpl;
import com.java.views.View;
import com.java.views.member.SignupFormView;

public class SignupController extends Controller {

	private View view = new SignupFormView();
	private MemberService memberService = new MemberServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		Map<String, Object> paramData = view.view(null);
		MemberVO memberVO = new MemberVO();
		memberVO.setId((String) paramMap.get("id"));
		memberVO.setPwd((String) paramData.get("pwd"));
		memberVO.setName((String) paramData.get("name"));
		memberVO.setPhone((String) paramData.get("phone"));
		try {
			memberService.regist(memberVO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
