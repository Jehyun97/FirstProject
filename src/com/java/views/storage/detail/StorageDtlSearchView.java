package com.java.views.storage.detail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.command.Criteria;
import com.java.dto.storage.detail.StorageDtlVO;
import com.java.service.storage.StorageServiceImpl;
import com.java.views.View;

public class StorageDtlSearchView extends View{
	
	StorageServiceImpl storageService = new StorageServiceImpl();
	
	{

		String menu = "========================================================\n"
					+ "=======[1] 식자재명으로 검색 [2] 식자재번호로 검색 [3] 뒤로가기========= ";

		setMenu(menu);
	}


	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		
		Map<String,Object> dataMap = new HashMap<String,Object>(param);
		Scanner scann = new Scanner(System.in);
		List<StorageDtlVO> storageList = (List<StorageDtlVO>) dataMap.get("storageList");
		
		System.out.println(getMenu());
		Criteria cri = new Criteria();
		String f_name = "";
		String sd_num = "";
		int menu = scann.nextInt();
		scann.nextLine();
		dataMap.put("menu", menu);
		boolean flag = true;
		String gubun = "";
		switch(menu) {
		case 1:
			dataMap.put("flag",true);
			gubun="n";
			System.out.print("식자재명 : "); dataMap.put("keyWord",scann.nextLine());
			break;
		case 2:
			dataMap.put("flag",true);
			gubun="i";
			System.out.println("식자재 번호 : "); dataMap.put("keyWord",scann.nextLine());
			break;
		case 3:
			dataMap.put("flag",false);
			break;
		}
		dataMap.put("searchType", gubun);
		
		return dataMap;
	}

}