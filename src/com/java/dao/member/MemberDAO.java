package com.java.dao.member;

import java.sql.SQLException;
import java.util.List;

import com.java.command.Criteria;
import com.java.dto.member.MemberVO;

public interface MemberDAO {

	List<MemberVO> selectMemberList(Criteria cri) throws SQLException;

	MemberVO selectMemberById(String id) throws SQLException;

	void insertMember(MemberVO member) throws SQLException;

	void updateMember(MemberVO member) throws SQLException;

	void deleteMember(String id) throws SQLException;

}
