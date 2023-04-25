package com.java.views.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.command.Criteria;
import com.java.dto.storage.StorageVO;
import com.java.service.storage.StorageService;
import com.java.service.storage.StorageServiceImpl;
import com.java.views.View;

public class StorageSearchView extends View {

	{

		String menu = "========================================================\n"
					+ "================[1] 수정할 창고 입력 [2] 뒤로가기================ ";

		setMenu(menu);
	}
	
	private StorageService storageService = new StorageServiceImpl();
	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		
		Criteria cri = new Criteria();
		cri.setKeyword("");
		cri.setSearchType("");
		Map<String,Object> dataMap = new HashMap<String,Object>(param);
		Scanner scann = new Scanner(System.in);
		
		List<StorageVO> StorageList; //수정된 창고정보
		try {
			StorageList = storageService.getStorageList(cri); 
			System.out.println("==============창고 리스트==============");
			if (StorageList != null)
				System.out.println("창고번호"+"\t"+"관리자"+"\t"+"공급번호"+"\t"+"위치");
				for (int i = 0; i < StorageList.size(); i++) {
					StorageVO storage = StorageList.get(i);
					System.out.println(storage);
				}
				
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(getMenu());
		String s_num = "";
		int menu = scann.nextInt();
		scann.nextLine();
		
		switch(menu) {
		case 1:
			System.out.print("창고번호 : "); s_num = scann.nextLine().toUpperCase();
			dataMap.put("flag",true);
			try {
				StorageVO storageList = storageService.getStorage(s_num);
				System.out.println("창고번호"+"\t"+"관리자"+"\t"+"공급번호"+"\t"+"위치");
				System.out.println(storageList);
				dataMap.put("storageList", storageList);
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			break;
		case 2:
			dataMap.put("flag",false);
			break;
		}
		return dataMap;
		
	
	}

	
	
}
