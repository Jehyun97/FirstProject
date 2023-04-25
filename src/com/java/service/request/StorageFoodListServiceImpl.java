package com.java.service.request;

import java.util.List;

import com.java.command.Criteria;
import com.java.dao.request.StorageFoodListDAO;
import com.java.dao.request.StorageFoodListDAOImpl;
import com.java.dto.request.StorageFoodListVO;

public class StorageFoodListServiceImpl implements StorageFoodListService{
	private StorageFoodListDAO storageFoodListDAO = new StorageFoodListDAOImpl();
	public void setFoodListDAO(StorageFoodListDAO storageFoodListDAO) {
		this.storageFoodListDAO = storageFoodListDAO;
		
		
	}
	@Override
	public List<StorageFoodListVO> getStorageFoodList(Criteria cri) throws Exception {
		List<StorageFoodListVO> foodList = storageFoodListDAO.selectStorageFoodList(cri);
		return foodList;
	}

}
