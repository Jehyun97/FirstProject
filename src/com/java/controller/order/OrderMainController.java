package com.java.controller.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.order.OrderListSearchVO;
import com.java.service.order.OrderLIstSearchServiceImpl;
import com.java.service.order.OrderListSearchService;
import com.java.views.order.OrderrMainView;

public class OrderMainController extends Controller {

	private OrderListSearchController olsController =new OrderListSearchController();
	private OrderListSearchService orderservice = new OrderLIstSearchServiceImpl();
	private OrderrMainView orderrView = new OrderrMainView();
	private OrderRegistController orderregiController = new OrderRegistController();
	private OrderModifyController orderModifyController = new OrderModifyController();
	private OrderRemoveController orderRemoveController = new OrderRemoveController();
	
	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap)  {
		boolean flag =true;
		while(flag) {
			Criteria cri = new Criteria();
			cri.setKeyword("");
			cri.setSearchType("");
			
			Map<String,Object> dataMap= new HashMap<String,Object>();
			List<OrderListSearchVO> orderList = null;
						
		     try {
				orderList= orderservice.getOrderList(cri);
				dataMap.put("orderList",orderList);
				Map<String,Object>returnMap = orderrView.view(dataMap);
				flag=(Boolean)returnMap.get("flag");
				if(!flag)continue;
				
				int menu =(Integer) returnMap.get("menu");
				switch(menu) {
				case 1:
					olsController.execute(null);
					break;
				case 2:
					orderregiController.execute(null);
					break;
				case 3:
					orderModifyController.execute(null);
					break;
				case 4:
					orderRemoveController.execute(null);
					break;
				case 5:
					flag=false;
					break;
					
			
					
					
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		return null;
	}
	
	
}
