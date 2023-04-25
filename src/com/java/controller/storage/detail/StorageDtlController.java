package com.java.controller.storage.detail;

import java.util.Map;

import com.java.controller.Controller;
import com.java.views.storage.detail.StorageDtlView;

public class StorageDtlController extends Controller {
	// 창고 상세 컨트롤러
	private StorageDtlView dtlView = new StorageDtlView();
	private StorageDtlSearchController dtlsearch = new StorageDtlSearchController();
	
	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		boolean flag = true;
		while (flag) {
			try {
				Map<String, Object> paramData = dtlView.view(paramMap);
				
				flag = (Boolean) paramData.get("flag");
				if (!flag) {
					continue;
				}else {
					dtlsearch.execute(paramData);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}
}
