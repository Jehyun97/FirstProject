package com.java.views.request;

import java.util.List;
import java.util.Map;

import com.java.dto.request.RequestVO;
import com.java.views.View;

public class RequestListView extends View {

	{
		String menu = "************** 요청 리스트 *******************\n";
		setMenu(menu);
	}

	@Override
	public Map<String, Object> view(Map<String, Object> param) {

		System.out.println("요청순서\t매장 코드\t식자재 코드\t식자재 수량\t요청날짜");
		List<RequestVO> requestList = (List<RequestVO>) param.get("requestList");

		for (int i = 0; i < requestList.size(); i++) {
			RequestVO request = requestList.get(i);
			System.out.println(request.getRe_num() + "\t" + request.getR_code() + "\t" + request.getF_code() + "\t"
					+ request.getRe_qty() + "\t" + request.getRe_date());
		}

		return null;

	}

}
