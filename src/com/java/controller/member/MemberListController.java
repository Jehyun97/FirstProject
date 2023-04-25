package com.java.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.member.MemberVO;
import com.java.service.member.MemberService;
import com.java.service.member.MemberServiceImpl;
import com.java.views.member.MemberListView;

public class MemberListController extends Controller {

	private MemberListView memberListView = new MemberListView();

	private MemberService memberService = new MemberServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		Criteria cri = new Criteria();
		cri.setKeyword("");
		cri.setSearchType("");

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MemberVO> memberList = null;

		try {
			memberList = memberService.getMemberList(cri);

			dataMap.put("memberList", memberList);
			Map<String, Object> returnMap = memberListView.view(dataMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
