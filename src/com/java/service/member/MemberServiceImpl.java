package com.java.service.member;

import java.util.List;

import com.java.command.Criteria;
import com.java.dao.member.MemberDAO;
import com.java.dao.member.MemberDAOImpl;
import com.java.dto.member.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO = new MemberDAOImpl();

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public List<MemberVO> getMemberList(Criteria cri) throws Exception {
		List<MemberVO> memberList = memberDAO.selectMemberList(cri);
		return memberList;
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}

	@Override
	public void regist(MemberVO member) throws Exception {
		memberDAO.insertMember(member);

	}

	@Override
	public void modify(MemberVO member) throws Exception {
		memberDAO.updateMember(member);
	}

	@Override
	public void remove(String id) throws Exception {
		memberDAO.deleteMember(id);
	}

}
