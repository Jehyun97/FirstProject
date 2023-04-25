package com.java.views.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.command.Criteria;
import com.java.dto.order.OrderListSearchVO;
import com.java.service.order.OrderLIstSearchServiceImpl;
import com.java.service.order.OrderListSearchService;
import com.java.views.View;

public class OrderListSearchView extends View {
	private OrderListSearchService orderservice = new OrderLIstSearchServiceImpl();

	Criteria cri = new Criteria();

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		cri.setKeyword("");
		cri.setSearchType("");
		Scanner scann = new Scanner(System.in);

		int menu = 1;
		try {
			System.out.println("[주문일자]\t\t[주문번호]\t\t[식자재명]\t\t[수량]\t[도매업체]\t[창고번호]");
			List<OrderListSearchVO> orderlist = orderservice.getOrderList(cri);
			List<OrderListSearchVO> orderList = (List<OrderListSearchVO>) param.get("orderList");
			if (orderList != null)
				for (int i = 0; i < orderList.size(); i++) {
					OrderListSearchVO order = orderList.get(i);
					System.out.println(order);

				}

//	
//			if(orderList.size()==orderlist.size()) {
//			System.out.print("SerchType을 선택하세요:");
//			System.out.println("SerchType: d(날짜),s(창고번호)");
//			String ST = scann.nextLine(); 
//			dataMap.put("ST",ST );
//			System.out.println("검색어를 업력하세요");
//			String KW = scann.nextLine();	
//			dataMap.put("KW",KW );
//			menu = 1;
//			dataMap.put("menu",menu);
//			}
//			else if(orderList.size()!= orderlist.size()){
//			System.out.println("[1] 다시검색 [2] 메인 화면으로");
//			menu = scann.nextInt();
//			dataMap.put("menu", menu);
//			
//				System.out.print("SerchType을 선택하세요:");
//				System.out.println("SerchType: d(날짜),s(창고번호)");
//				String ST = scann.nextLine(); 
//				dataMap.put("ST",ST );
//				System.out.println("검색어를 업력하세요");
//				String KW = scann.nextLine();	
//				dataMap.put("KW",KW );
//			
//			}
			int returnMenu = (Integer) param.get("returnMenu");
			switch (returnMenu) {
			case 1:
				System.out.print("SerchType을 선택하세요:");
				System.out.println("SerchType: d(날짜),s(창고번호)");
				String ST = scann.nextLine();
				dataMap.put("ST", ST);
				System.out.println("검색어를 업력하세요");
				String KW = scann.nextLine().toUpperCase();
				dataMap.put("KW", KW);
				menu = 1;
				dataMap.put("menu", menu);
				break;
			case 2:
				System.out.println("[1] 다시검색 [2] 메인 화면으로");
				menu = scann.nextInt();
				scann.nextLine();
				dataMap.put("menu", menu);
				if(menu==1) { 	
			    System.out.print("SerchType을 선택하세요:");
				System.out.println("SerchType: d(날짜),s(창고번호)");
				ST = scann.nextLine();
				dataMap.put("ST", ST);
				System.out.println("검색어를 업력하세요");
				KW = scann.nextLine().toUpperCase();
				dataMap.put("KW", KW);
				}else {
					menu = 2;
					dataMap.put("menu",menu);
				}
				break;
			}

		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataMap;

	}

}
