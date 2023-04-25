package com.java.service.member;

import java.util.List;

import com.java.command.Criteria;
import com.java.dto.member.MemberVO;

public interface MemberService {

	public List<MemberVO> getMemberList(Criteria cri) throws Exception;

	public MemberVO getMember(String id) throws Exception;

	public void regist(MemberVO member) throws Exception;

	public void modify(MemberVO member) throws Exception;

	public void remove(String id) throws Exception;
}
