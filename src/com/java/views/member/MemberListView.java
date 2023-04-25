package com.java.views.member;

import java.util.List;
import java.util.Map;

import com.java.dto.member.MemberVO;
import com.java.views.View;

public class MemberListView extends View {

	{
		String menu = "************** 회원조회 *******************\n";
		setMenu(menu);

	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {

		System.out.println("번호\t이름\t전화번호");
		List<MemberVO> memberList = (List<MemberVO>) param.get("memberList");

		for (int i = 0; i < memberList.size(); i++) {
			MemberVO mem = memberList.get(i);
			System.out.println((i + 1) + "\t" + mem.getName() + "\t" + mem.getPhone());
		}
		return null;
	}

}
