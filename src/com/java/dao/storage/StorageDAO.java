package com.java.dao.storage;

import java.sql.SQLException;
import java.util.List;

import com.java.command.Criteria;
import com.java.dto.storage.StorageVO;

public interface StorageDAO {
	List<StorageVO> selectStorageList(Criteria cri) throws SQLException;
	
	StorageVO selectStorageBySnum(String s_num) throws SQLException;
	
	void insertStorage(StorageVO storage) throws SQLException;
	
	void updateStorage(StorageVO storage) throws SQLException;
	
	void deleteStorage(String s_num) throws SQLException;
}
