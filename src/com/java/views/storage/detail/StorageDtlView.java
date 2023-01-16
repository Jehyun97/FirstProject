package com.java.views.storage.detail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.dto.storage.StorageVO;
import com.java.dto.storage.detail.StorageDtlVO;
import com.java.service.storage.StorageService;
import com.java.service.storage.StorageServiceImpl;
import com.java.views.View;

public class StorageDtlView extends View {

	{

		String menu = "***********************************************\n" + "****[1] 창고검색  [2] 뒤로가기********** ";

		setMenu(menu);
	}

	private StorageService storageService = new StorageServiceImpl();

	@Override
	public Map<String, Object> view(Map<String, Object> param) {

		Map<String, Object> dataMap = new HashMap<String, Object>(param);
		Scanner scann = new Scanner(System.in);
		List<StorageVO> storageList = (List<StorageVO>) dataMap.get("storageList");

		System.out.println("\n ---------- 등록된 창고 리스트 ---------- ");
		if (storageList != null)
			System.out.println("창고번호" + "\t" + "관리자" + "\t" + "공급번호" + "\t" + "위치");
		for (int i = 0; i < storageList.size(); i++) {
			StorageVO storage = storageList.get(i);
			System.out.println(storage);
		}

		System.out.println(getMenu());

		String s_num = "";
		int menu = scann.nextInt();
		scann.nextLine();

		switch (menu) {
		case 1:
			System.out.print("창고번호 : ");
			s_num = scann.nextLine().toUpperCase();
			dataMap.put("flag", true);
			try {
				List<StorageDtlVO> storageDtlList = storageService.getDtlStorage(s_num);
				if (storageDtlList.size() > 0) {
					System.out.println("-------------------------[" + s_num + "] 창고 식자재 리스트-----------------------");
					System.out.println("");
					System.out.println("식자재번호" + "\t" + "식자재명" + "\t" + "창고번호" + "\t" + "식자재코드" + "\t" + "보유수량" + "\t"
							+ "적정재고" + "\t" + "섹션" + "\t" + "유통기한");
					for (int i = 0; i < storageDtlList.size(); i++) {
						StorageDtlVO storage = storageDtlList.get(i);
						System.out.println(storage);
					}
				} else
					System.out.println("창고가 비어있습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 2:
			dataMap.put("flag", false);
		}

		return dataMap;
	}
}