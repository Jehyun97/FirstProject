package com.java.views.request;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.command.Criteria;
import com.java.dto.request.StorageFoodListVO;
import com.java.service.request.StorageFoodListService;
import com.java.service.request.StorageFoodListServiceImpl;
import com.java.views.View;

public class StorageFoodListView extends View {

	private StorageFoodListService foodListService = new StorageFoodListServiceImpl();
	Scanner scan = new Scanner(System.in);
	Criteria cri = new Criteria();
	
	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		cri.setKeyword("");
		cri.setSearchType("");
		
		try {
			System.out.println("창고 번호\t식자재명\t보유 수량");
			List<StorageFoodListVO> foodList = foodListService.getStorageFoodList(cri);
			
			if(foodList != null)
				for (int i = 0; i < foodList.size(); i++) {
					StorageFoodListVO food = foodList.get(i);
					System.out.println(food);
				}
			System.out.println("이전화면으로 돌아갑니다. 엔터를 눌러주세요");
			scan.nextLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
