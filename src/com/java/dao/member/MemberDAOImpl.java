package com.java.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.command.Criteria;
import com.java.dataSource.DataSource;
import com.java.dto.member.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private DataSource dataSource = DataSource.getInstance();

	@Override
	public List<MemberVO> selectMemberList(Criteria cri) throws SQLException {

		List<MemberVO> memberList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();

			String sql = "select * from manager ";

			switch (cri.getSearchType()) {
			case "i": // 아이디 검색
				sql += "  where id like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			case "n": // 이름검색
				sql += "  where name like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			case "p": // 전화번호 검색
				sql += "  where phone like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			}

			rs = stmt.executeQuery(sql);

			memberList = toMemberList(rs);

			return memberList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO member = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			conn = dataSource.getConnection();
			String sql = "select * from manager where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			List<MemberVO> memberList = toMemberList(rs);
			if (memberList.size() > 0)
				member = memberList.get(0);

			return member;

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = " insert into" + "  manager(id, pwd, name, phone)" + "  values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update manager" + " set" + " name=?, phone=? " + " where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getId());

			pstmt.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	@Override
	public void deleteMember(String id) throws SQLException {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from manager where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	private List<MemberVO> toMemberList(ResultSet rs) throws SQLException {

		List<MemberVO> memberList = new ArrayList<MemberVO>();
		while (rs.next()) {
			MemberVO member = new MemberVO();

			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPhone(rs.getString("phone"));
			member.setPwd(rs.getString("pwd"));

			memberList.add(member);
		}
		return memberList;

	}
}
