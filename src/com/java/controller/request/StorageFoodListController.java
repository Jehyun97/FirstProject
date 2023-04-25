package com.java.controller.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.request.StorageFoodListVO;
import com.java.service.request.StorageFoodListService;
import com.java.service.request.StorageFoodListServiceImpl;
import com.java.views.View;
import com.java.views.request.StorageFoodListView;

public class StorageFoodListController extends Controller {

	private View view = new StorageFoodListView();
	private StorageFoodListService storageFoodListService = new StorageFoodListServiceImpl();

	Criteria cri = new Criteria();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;

		cri.setKeyword("");
		cri.setSearchType("");

		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();

			List<StorageFoodListVO> foodList = storageFoodListService.getStorageFoodList(cri);
			dataMap.put("foodList", foodList);
			Map<String, Object> paramData = view.view(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
