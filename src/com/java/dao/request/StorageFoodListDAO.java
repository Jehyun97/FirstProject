package com.java.dao.request;

import java.sql.SQLException;
import java.util.List;

import com.java.command.Criteria;
import com.java.dto.request.StorageFoodListVO;

;

public interface StorageFoodListDAO {
	
	List<StorageFoodListVO> selectStorageFoodList(Criteria cri) throws SQLException;

	
}