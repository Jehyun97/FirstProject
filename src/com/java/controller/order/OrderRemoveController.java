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
import com.java.views.order.OrderRemoveView;

public class OrderRemoveController extends Controller{
	private View view = new OrderRemoveView();
	private OrderService ODservice = new OrderServiceImpl();
	Criteria cri = new Criteria();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		
		while(flag) {
			Map<String,Object> dataMap = new HashMap<String,Object>();
			cri.setKeyword("");
			cri.setSearchType("");
			if(!flag)
				continue;
			try {
				List<OrderVO> orderlist = ODservice.getOrderList(cri);
				dataMap.put("orderlist",orderlist);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	Map<String,Object>paramData = view.view(dataMap);
 	
 	String Ocode =(String)paramData.get("Ocode");
 	try {
		ODservice.remove(Ocode);
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	
		flag =(Boolean)paramData.get("flag");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
			
			
			
			
			
			
			
		}
		return null;
	}

}
