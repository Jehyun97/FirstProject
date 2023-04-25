package com.java.service.request;

import java.util.List;

import com.java.command.Criteria;
import com.java.dto.request.StorageFoodListVO;

public interface StorageFoodListService {
	
	public List<StorageFoodListVO> getStorageFoodList(Criteria cri)throws Exception;
	
}
