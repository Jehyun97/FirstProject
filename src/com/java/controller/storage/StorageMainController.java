package com.java.controller.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.controller.request.StorageFoodListController;
import com.java.controller.storage.detail.StorageDtlController;
import com.java.dto.storage.StorageVO;
import com.java.service.storage.StorageService;
import com.java.service.storage.StorageServiceImpl;
import com.java.views.storage.StorageMainView;

public class StorageMainController extends Controller {

	private StorageFoodListController StorageFoodListController = new StorageFoodListController();
	private StorageDtlController storageDtlController = new StorageDtlController();
	// 창고관리
//	private StorageModifyController storageModifyController = new StorageModifyController();
	private StorageSearchController storageSearchController = new StorageSearchController();
	private StorageMainView View = new StorageMainView();

	private StorageService storageService = new StorageServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		while (flag) {

			Criteria cri = new Criteria();
			cri.setKeyword("");
			cri.setSearchType("");

			Map<String, Object> dataMap = new HashMap<String, Object>();
			List<StorageVO> storageList = null;

			try {
				storageList = storageService.getStorageList(cri);

				dataMap.put("storageList", storageList);

				Map<String, Object> returnMap = View.view(null);
				flag = (Boolean) returnMap.get("flag");

				if (!flag)
					continue;

				int menu = (Integer) returnMap.get("menu");

				switch (menu) {
				case 1: // 창고입출고 내역 조회
					storageDtlController.execute(dataMap);
					break;
				case 2:// 창고 정보 수정
						// storageModifyController.execute(null);
					storageSearchController.execute(dataMap);
					break;
				case 3:// 전체 창고 식재료 수량 보기
					StorageFoodListController.execute(null);
					break;
				case 4:// 뒤로가기
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// 상품서비스
		// 주문서비스
		return null;
	}
}
