package com.java.dao.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.command.Criteria;
import com.java.dataSource.DataSource;
import com.java.dto.request.RequestVO;

public class RequestDAOImpl implements RequestDAO {

	private DataSource dataSource = DataSource.getInstance();

	@Override
	public List<RequestVO> selectRequestList(Criteria cri) throws SQLException {
		List<RequestVO> requestList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();

			String sql = "select * from request ";

			switch (cri.getSearchType()) {
			case "r": // 매장명 검색
				sql += "  where r_code like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			case "f": // 식자재명 검색
				sql += "  where f_code like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			}

			rs = stmt.executeQuery(sql);

			requestList = toRequestList(rs);

			return requestList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public RequestVO selectRequestByNum(String re_num) throws SQLException {
		RequestVO request = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			conn = dataSource.getConnection();
			String sql = "select * from request where re_num=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, re_num);
			ResultSet rs = pstmt.executeQuery();
			List<RequestVO> requestList = toRequestList(rs);
			if (requestList.size() > 0)
				request = requestList.get(0);

			return request;

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void insertRequest(RequestVO request) throws SQLException {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = " insert into" + "  request(re_num, r_code, f_code, re_date, re_qty)" + "  values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getRe_num());
			pstmt.setString(2, request.getR_code());
			pstmt.setString(3, request.getF_code());
			pstmt.setString(4, request.getRe_date());
			pstmt.setString(5, request.getRe_qty());

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
	public void updateRequest(RequestVO request) throws SQLException {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update request" + " set" + " re_qty=?, re_date=?" + " where re_num = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getRe_qty());
			pstmt.setString(2, request.getRe_date());
			pstmt.setString(3, request.getRe_num());

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
	public void deleteRequest(String re_code) throws SQLException {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from request where re_num=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, re_code);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	private List<RequestVO> toRequestList(ResultSet rs) throws SQLException {

		List<RequestVO> requestList = new ArrayList<RequestVO>();
		while (rs.next()) {
			RequestVO request = new RequestVO();

			request.setRe_num(rs.getString("re_num"));
			request.setR_code(rs.getString("r_code"));
			request.setF_code(rs.getString("f_code"));
			request.setRe_date(rs.getString("re_date"));
			request.setRe_qty(rs.getString("re_qty"));

			requestList.add(request);
		}
		return requestList;

	}

}
