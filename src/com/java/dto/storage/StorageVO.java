package com.java.dto.storage;

import java.util.List;

import com.java.dto.storage.detail.StorageDtlVO;

public class StorageVO {
	
	private String s_num;
	private String id;
	private int re_num;
	private String s_loc;
	
	private List<StorageDtlVO> storagedtlList;
	

	public StorageVO() {}
	
	public StorageVO(String s_num, String id) {
		super();
		this.s_num = s_num;
		this.id=id;
	}

	public String getS_num() {
		return s_num;
	}

	public void setS_num(String s_num) {
		this.s_num = s_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRe_num() {
		return re_num;
	}

	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}

	public String getS_loc() {
		return s_loc;
	}

	public void setS_loc(String s_loc) {
		this.s_loc = s_loc;
	}


	
	
	public List<StorageDtlVO> getStoragedtlList() {
		return storagedtlList;
	}

	public void setStoragedtlList(List<StorageDtlVO> storagedtlList) {
		this.storagedtlList = storagedtlList;
	}

	@Override
	public String toString() {
		return s_num+"\t"+ id+"\t"+ re_num+"\t"+ s_loc+"\n";
	}
	
	
	
	
	

}
