package com.java.controller.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.java.controller.Controller;
import com.java.dto.order.OrderVO;
import com.java.dto.storage.detail.StorageDtlVO;
import com.java.service.order.OrderService;
import com.java.service.order.OrderServiceImpl;
import com.java.service.storage.StorageService;
import com.java.service.storage.StorageServiceImpl;
import com.java.views.View;
import com.java.views.order.OrderRegistView;

public class OrderRegistController extends Controller {
	private OrderRegistView orderRegistView = new OrderRegistView();
	private OrderService ODservice = new OrderServiceImpl();
	private StorageService storageService = new StorageServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		boolean flag = true;

		while (flag) {
			OrderVO orderVO = new OrderVO();
//			Map<String, Object> dataMap = new HashMap<String, Object>();
			Map<String, Object> paramData = orderRegistView.view(null);
			Map<String, Object> dataMap = paramData;
			StorageDtlVO storagedtl = new StorageDtlVO();
			String odate = (String) paramData.get("Odate");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.mm.dd");

			try {
				java.util.Date o_date = simpleDateFormat.parse(odate);
				java.sql.Date Oodate = new java.sql.Date(o_date.getTime());
				orderVO.setOdate(Oodate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			orderVO.setFcode((String) paramData.get("Fcode"));
			orderVO.setOcode((String) paramData.get("Ocode"));
			orderVO.setOqty((int) paramData.get("Oqty"));
			orderVO.setSnum((String) paramData.get("Snum"));
			////////////////////////////////////////////////////

			try {
				ODservice.regist(orderVO);
				flag = (Boolean) paramData.get("flag");
			} catch (Exception e) {
				e.printStackTrace();
			}

			String addmenu = (String) dataMap.get("addmenu");

			switch (addmenu) {

			case "Y":
				storagedtl.setF_code((String) dataMap.get("Fcode"));
				storagedtl.setSd_qty((int) dataMap.get("Oqty"));
				storagedtl.setS_num((String) dataMap.get("Snum"));
				storagedtl.setSd_section((String) dataMap.get("section"));
				storagedtl.setSd_standard((int) dataMap.get("sdstandard"));
				storagedtl.setSd_num((String) dataMap.get("sd_num"));
				paramData.put("flag", true);

				try {
					storageService.addStorageDtl(storagedtl);
					flag = (Boolean) paramData.get("flag");
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			case "N":
				flag = false;
				break;
			}

			int menu = (int) dataMap.get("menu");

			switch (menu) {

			case 1:
				flag = true;
				continue;

			case 2:
				flag = false;

			}

		}

		return null;
	}

}