package com.java.controller.request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.java.controller.Controller;
import com.java.dto.request.RequestVO;
import com.java.dto.storage.detail.StorageDtlVO;
import com.java.service.request.RequestService;
import com.java.service.request.RequestServiceImpl;
import com.java.service.storage.StorageService;
import com.java.service.storage.StorageServiceImpl;
import com.java.views.request.RequestFoodView;

public class RequestFoodController extends Controller {

	private RequestFoodView requestFoodView = new RequestFoodView();
	private RequestService requestService = new RequestServiceImpl();
	private StorageService storageService = new StorageServiceImpl();
	RequestVO requestVO = new RequestVO();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		boolean flag = true;

		while (flag) {
			Map<String, Object> paramData = requestFoodView.view(null);
			Map<String, Object> dataMap = paramData;
			StorageDtlVO storagedtl = new StorageDtlVO();
			String redate = (String) paramData.get("re_date");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.mm.dd");

			try {
				java.util.Date Redate = simpleDateFormat.parse(redate);
				java.sql.Date Rr_date = new java.sql.Date(Redate.getTime());
				requestVO.setRe_date(Rr_date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			requestVO.setRe_num((String) paramData.get("re_num"));
			requestVO.setR_code((String) paramData.get("r_code"));
			requestVO.setF_code((String) paramData.get("f_code"));
			requestVO.setRe_qty((Integer) paramData.get("re_qty"));

			try {
				requestService.regist(requestVO);
				flag = (Boolean) paramData.get("flag");
			} catch (Exception e) {
				e.printStackTrace();
			}

			String menu = (String) dataMap.get("menu");

			switch (menu) {
			case "Y":
				int a = (Integer) paramData.get("re_qty");
				storagedtl.setF_code((String) paramData.get("f_code"));
				storagedtl.setS_num((String) paramData.get("s_num"));
				storagedtl.setSd_num((String) paramData.get("sd_num"));
				storagedtl.setSd_qty(-a);
				paramData.put("flag", true);

				try {
					storageService.addStorageDtl(storagedtl);
					flag = (Boolean) paramData.get("flag");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case "N":
				flag = false;
				break;
			}
			// dataMap.get("flag");

		}

		return null;

	}

}
