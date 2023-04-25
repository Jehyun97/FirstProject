package com.java.service.request;

import java.util.List;

import com.java.command.Criteria;
import com.java.dto.request.RequestVO;

public interface RequestService {

	public List<RequestVO> getRequestList(Criteria cri) throws Exception;

	public RequestVO getRequest(String code) throws Exception;

	public void regist(RequestVO request) throws Exception;

	public void modify(RequestVO request) throws Exception;

	public void remove(String code) throws Exception;

}
