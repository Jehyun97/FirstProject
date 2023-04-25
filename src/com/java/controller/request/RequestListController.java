package com.java.controller.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.request.RequestVO;
import com.java.service.request.RequestService;
import com.java.service.request.RequestServiceImpl;
import com.java.views.request.RequestListView;

public class RequestListController extends Controller {

	private RequestListView requestListView = new RequestListView();

	private RequestService requestService = new RequestServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		Criteria cri = new Criteria();
		cri.setKeyword("");
		cri.setSearchType("");

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<RequestVO> requestList = null;

		try {
			requestList = requestService.getRequestList(cri);

			dataMap.put("requestList", requestList);
			Map<String, Object> returnMap = requestListView.view(dataMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
