package com.java.controller.request;

import java.util.Map;

import com.java.controller.Controller;
import com.java.dto.request.RequestVO;
import com.java.service.request.RequestService;
import com.java.service.request.RequestServiceImpl;

import com.java.views.request.RequestFoodView;

public class RequestFoodController extends Controller {

	private RequestFoodView requestFoodView = new RequestFoodView();
	private RequestService requestService = new RequestServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		Map<String, Object> paramData = requestFoodView.view(null);
		RequestVO requestVO = new RequestVO();
		requestVO.setF_code((String) paramData.get("f_code"));
		requestVO.setRe_qty((String) paramData.get("re_qty"));

		try {
			requestService.regist(requestVO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
