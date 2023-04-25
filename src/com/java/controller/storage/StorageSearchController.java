package com.java.controller.storage;

import java.util.Map;

import com.java.controller.Controller;
import com.java.views.storage.StorageSearchView;

public class StorageSearchController extends Controller {
	private StorageSearchView searchView = new StorageSearchView();
	private StorageModifyController modify = new StorageModifyController();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		while (flag) {
			try {
				Map<String, Object> paramData = searchView.view(paramMap);
				flag = (Boolean) paramData.get("flag");

				if (!flag) {
					continue;
				} else
					modify.execute(paramData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
