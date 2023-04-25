package com.java.controller.member;

import java.util.Map;

import com.java.controller.Controller;
import com.java.dto.member.MemberVO;
import com.java.service.member.MemberService;
import com.java.service.member.MemberServiceImpl;
import com.java.views.member.UpdateMemberView;

public class UpdateMemberController extends Controller {

	private UpdateMemberView updateMemberView = new UpdateMemberView();
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		
		Map<String, Object> paramData = updateMemberView.view(paramMap);
		MemberVO memberVO = new MemberVO();
		memberVO.setId((String) paramMap.get("id"));
		memberVO.setName((String) paramData.get("name"));
		memberVO.setPhone((String) paramData.get("phone"));
		
		try {
			memberService.modify(memberVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
