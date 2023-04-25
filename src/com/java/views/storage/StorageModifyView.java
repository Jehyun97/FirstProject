package com.java.views.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.views.View;

public class StorageModifyView extends View {
	

	@Override
	public Map<String, Object> view(Map<String, Object> param) {
		Map<String, Object> modifyMap = new HashMap<String, Object>();
		Scanner scann = new Scanner(System.in);
		
		System.out.println("창고 위치 변경: "); modifyMap.put("s_loc", scann.nextLine().toUpperCase());
	    System.out.println("==============수정 완료==============");
	    
	    return modifyMap;
	}
}
