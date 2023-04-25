package com.java.controller.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.order.OrderVO;
import com.java.service.order.OrderService;
import com.java.service.order.OrderServiceImpl;
import com.java.views.View;
import com.java.views.order.OrderModifyView;

public class OrderModifyController extends Controller {
private View view = new OrderModifyView();
private OrderService ODservice = new OrderServiceImpl();
Criteria cri = new Criteria();	
	
	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		do {
			Map<String,Object> dataMap = new HashMap<String,Object>();
			cri.setKeyword("");
			cri.setSearchType("");
			try {
				List<OrderVO> orderlist = ODservice.getOrderList(cri);
				dataMap.put("OcodebyList", orderlist);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Map<String,Object>paramData = view.view(dataMap);
			
		
			String Ocode = (String) paramData.get("Ocode");
			try {
				OrderVO orderr = ODservice.getOrder(Ocode);
				OrderVO Order = orderr;
				String menu = (String)paramData.get("menu");
				switch(menu) {
				case "F":
				Order.setFcode((String)paramData.get("Fcode"));
				ODservice.modify(Order);
				break;
				case "Q":
					Order.setOqty((int)paramData.get("Oqty"));
					ODservice.modify(Order);
					break;
				case "S":
					Order.setSnum((String)paramData.get("Snum"));
					ODservice.modify(Order);
					break;
				}
		
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	flag =(Boolean)paramData.get("flag");
				
		
			
			
			
		}while(flag!=false);
		
	
		return null;
	}

}
