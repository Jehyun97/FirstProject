package com.java.dao.request;

import java.sql.SQLException;
import java.util.List;

import com.java.command.Criteria;
import com.java.dto.request.RequestVO;




public interface RequestDAO {
	
	List<RequestVO> selectRequestList(Criteria cri) throws SQLException;

	RequestVO selectRequestByNum(String re_num) throws SQLException;

	void insertRequest(RequestVO request) throws SQLException;

	void updateRequest(RequestVO request) throws SQLException;

	void deleteRequest(String re_num) throws SQLException;

}
