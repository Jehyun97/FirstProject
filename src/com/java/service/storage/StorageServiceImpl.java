package com.java.service.storage;

import java.sql.SQLException;
import java.util.List;

import com.java.command.Criteria;
import com.java.dao.storage.StorageDAO;
import com.java.dao.storage.StorageDAOImpl;
import com.java.dao.storage.detail.StorageDtlDAO;
import com.java.dao.storage.detail.StorageDtlDAOImpl;
import com.java.dto.storage.StorageVO;
import com.java.dto.storage.detail.StorageDtlVO;

public class StorageServiceImpl implements StorageService{

	private StorageDAO storageDAO = new StorageDAOImpl(); 
	private StorageDtlDAO storageDtlDAO = new StorageDtlDAOImpl();
	
	public void setStorageDAO(StorageDAO storageDAO) {
		this.storageDAO = storageDAO;
	}
	
	
	@Override
	public List<StorageVO> getStorageList(Criteria cri) throws Exception {
		
		List<StorageVO> storageList = storageDAO.selectStorageList(cri);
		
		
		return storageList;
	}

	@Override
	public StorageVO getStorage(String s_num) throws Exception {
		
		StorageVO storage = storageDAO.selectStorageBySnum(s_num);
		
		
		
		return storage;
		
		
	}

	@Override
	public void regist(StorageVO storage) throws Exception {
		storageDAO.insertStorage(storage);
		
	}

	@Override
	public void modify(StorageVO storage) throws Exception {
		storageDAO.updateStorage(storage);
	}

	@Override
	public void remove(String s_num) throws Exception {
		storageDAO.deleteStorage(s_num);
	}

	@Override
	public void addStorageDtl(StorageDtlVO storageDtl) throws Exception {
		storageDtlDAO.insertStorageDtl(storageDtl);
	}

	@Override
	public void modifyStorageDtl(StorageDtlVO storageDtl) throws Exception {
		storageDtlDAO.updateStorageDtl(storageDtl);
	}

	@Override
	public void removeStorageDtl(String sd_num) throws Exception {
		storageDtlDAO.deleteStorageDtl(sd_num);
	}


	@Override
	public List<StorageDtlVO> getDtlStorage(String s_num) {
		List<StorageDtlVO> storageDtlVO = null;
		try {
			storageDtlVO = storageDtlDAO.selectStorageDtlList(s_num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storageDtlVO;
	}


	@Override
	public List<StorageDtlVO> getDtlStorageCri(Criteria cri,String s_num) {
		List<StorageDtlVO> storageDtlList = null;
		try {
			storageDtlList = storageDtlDAO.selectStorageDtlByCri(cri,s_num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storageDtlList;
	}
	
	

	

}
