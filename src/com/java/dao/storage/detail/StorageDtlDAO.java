package com.java.dao.storage.detail;

import java.sql.SQLException;
import java.util.List;

import com.java.command.Criteria;
import com.java.dto.storage.detail.StorageDtlVO;

public interface StorageDtlDAO {

	//창고번호(s_num)의 상세 리스트
	List<StorageDtlVO> selectStorageDtlList(String s_num)throws SQLException;
	
	List<StorageDtlVO> selectStorageDtlByCri(Criteria cri,String s_num)throws SQLException;
	
	StorageDtlVO selectStorageDtlBySdnum(String sd_num)throws SQLException;
	
	void insertStorageDtl(StorageDtlVO storageDtl)throws SQLException;
	
	void updateStorageDtl(StorageDtlVO storageDtl)throws SQLException;
	
	void deleteStorageDtl(String sd_num)throws SQLException;
}
