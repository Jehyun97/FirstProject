package com.java.dto.request;

public class StorageFoodListVO {

	private String S_num;
	private String F_name;
	private int SD_qty;

	public String getS_num() {
		return S_num;
	}

	public void setS_num(String s_num) {
		S_num = s_num;
	}

	public String getF_name() {
		return F_name;
	}

	public void setF_name(String f_name) {
		F_name = f_name;
	}

	public int getSD_qty() {
		return SD_qty;
	}

	public void setSD_qty(int sD_qty) {
		SD_qty = sD_qty;
	}

	@Override
	public String toString() {
		return  S_num + "\t" + F_name + "\t" + SD_qty + "\n";
	}

}
