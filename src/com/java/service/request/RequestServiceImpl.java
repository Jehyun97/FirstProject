package com.java.service.request;

import java.util.List;

import com.java.command.Criteria;
import com.java.dao.request.RequestDAO;
import com.java.dao.request.RequestDAOImpl;
import com.java.dto.member.MemberVO;
import com.java.dto.request.RequestVO;

public class RequestServiceImpl implements RequestService {

	private RequestDAO requestDAO = new RequestDAOImpl();

	public void setRequestDAO(RequestDAO requestDAO) {
		this.requestDAO = requestDAO;
	}

	public List<RequestVO> getRequestList(Criteria cri) throws Exception {
		List<RequestVO> requestList = requestDAO.selectRequestList(cri);
		return requestList;
	}

	@Override
	public RequestVO getRequest(String re_num) throws Exception {
		RequestVO request = requestDAO.selectRequestByNum(re_num);
		return request;
	}

	@Override
	public void regist(RequestVO request) throws Exception {
		requestDAO.insertRequest(request);

	}

	@Override
	public void modify(RequestVO request) throws Exception {
		requestDAO.updateRequest(request);

	}

	@Override
	public void remove(String re_num) throws Exception {
		requestDAO.deleteRequest(re_num);

	}

}