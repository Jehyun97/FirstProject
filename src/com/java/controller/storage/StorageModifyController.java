package com.java.controller.storage;

import java.util.HashMap;
import java.util.Map;

import com.java.controller.Controller;
import com.java.dto.storage.StorageVO;
import com.java.service.storage.StorageServiceImpl;
import com.java.views.storage.StorageModifyView;

public class StorageModifyController extends Controller {

	private StorageServiceImpl serviceImpl = new StorageServiceImpl();
	private StorageModifyView modifyview = new StorageModifyView();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		Map<String, Object> dataMap = new HashMap<String, Object>(paramMap);
		StorageVO storage = new StorageVO();
		storage = (StorageVO) dataMap.get("storageList"); // search한 창고리스트

		Map<String, Object> paramData = modifyview.view(null);

		try {
			storage.setS_loc((String) paramData.get("s_loc"));

			serviceImpl.modify(storage);

			System.out.println(storage); // 수정한 결과

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}