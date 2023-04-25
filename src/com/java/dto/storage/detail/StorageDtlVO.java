package com.java.dto.storage.detail;

import java.util.Date;


public class StorageDtlVO {

	private String sd_num; //식자재상세번호
	private String s_num; //창고번호
	private String f_code; //식자재코드
	private int sd_qty; //보유수량
	private int sd_standard; //적정재고
	private String sd_section; //섹션(보관위치)
//	private Date sd_date; //유통기한
	private String sd_date; //유통기한
	private String f_name;
	
	
//	public StorageDtlVO() {}
	
//	public StorageDtlVO(String sd_num, int sd_qty) {
//		super();
//		this.sd_num= sd_num;
//		this.sd_qty= sd_qty;
//	}
	
	
	
	public String getSd_num() {
		return sd_num;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public void setSd_num(String sd_num) {
		this.sd_num = sd_num;
	}
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getF_code() {
		return f_code;
	}
	public void setF_code(String f_code) {
		this.f_code = f_code;
	}
	public int getSd_qty() {
		return sd_qty;
	}
	public void setSd_qty(int sd_qty) {
		this.sd_qty = sd_qty;
	}
	public int getSd_standard() {
		return sd_standard;
	}
	public void setSd_standard(int sd_standard) {
		this.sd_standard = sd_standard;
	}
	public String getSd_section() {
		return sd_section;
	}
	public void setSd_section(String sd_section) {
		this.sd_section = sd_section;
	}
	public String getSd_date() {
		return sd_date;
	}
	public void setSd_date(String sd_date) {
		this.sd_date = sd_date;
	}



	@Override
	public String toString() {
		return sd_num +"\t"+f_name+"\t"+ s_num +"\t"+ f_code + "\t" + sd_qty
				+ "\t" + sd_standard + "\t" + sd_section + "\t"+ sd_date + "\n";
		
		
		
	}
	
	
	
	
}
