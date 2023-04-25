package com.java.service.storage;

import java.util.List;

import com.java.command.Criteria;
import com.java.dto.storage.StorageVO;
import com.java.dto.storage.detail.StorageDtlVO;

public interface StorageService {

	// 창고검색
	public List<StorageVO> getStorageList(Criteria cri) throws Exception;
	// 창고상세
	public StorageVO getStorage(String s_num) throws Exception;
	// 창고등록
	public void regist(StorageVO storage) throws Exception;
	// 창고수정
	public void modify(StorageVO storage) throws Exception;
	// 창고삭제
	public void remove(String s_num) throws Exception;
	
	// 창고 보유 식자재 추가
	public void addStorageDtl(StorageDtlVO storageDtl) throws Exception;
	// 창고 보유 식자재 수정
	public void modifyStorageDtl(StorageDtlVO storageDtl) throws Exception;
	public void removeStorageDtl(String sd_num) throws Exception;
	
	//창고 상세 식자재 보기
	public List<StorageDtlVO> getDtlStorage(String s_num);
	
	//창고 상세 식자재 키워드 검색
	public List<StorageDtlVO> getDtlStorageCri(Criteria cri,String s_num);

	
	
}