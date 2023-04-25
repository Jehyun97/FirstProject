package com.java.controller.storage.detail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.dto.storage.detail.StorageDtlVO;
import com.java.service.storage.StorageServiceImpl;
import com.java.views.storage.detail.StorageDtlSearchView;

public class StorageDtlSearchController extends Controller {
	private StorageDtlSearchView dtlview = new StorageDtlSearchView();
	private StorageServiceImpl serviceImpl = new StorageServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		while (flag) {
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>(paramMap);
//				StorageDtlVO dtlList = new StorageDtlVO();
				
				
				Map<String, Object> paramData = dtlview.view(paramMap);
				flag = (Boolean) paramData.get("flag");
				Criteria cri = new Criteria();
				String s_num = (String)dataMap.get("s_num");
				if (!flag)
					continue;
				

				int menu = (Integer) paramData.get("menu");
				String searchType = (String)paramData.get("searchType");
				String keyWord = (String)paramData.get("keyWord");
				switch (menu) {
				case 1: // 식자재명으로 검색
					cri.setSearchType(searchType);
					cri.setKeyword(keyWord);
					
					List<StorageDtlVO> dtlList = serviceImpl.getDtlStorageCri(cri,s_num);
					if(dtlList.size()==0) {
						System.out.println("등록되지않은 식자재: 다시입력하세요.");
					}else
					System.out.println(dtlList);
					break;
				case 2:// 식자재 번호로 검색
					cri.setSearchType(searchType);
					cri.setKeyword(keyWord);
					dtlList = serviceImpl.getDtlStorageCri(cri, s_num);
					if(dtlList.size()==0) {
						System.out.println("등록되지않은 식자재: 다시입력하세요.");
					}else
					System.out.println(dtlList);
					break;
				case 3:// 이전메뉴
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}
}