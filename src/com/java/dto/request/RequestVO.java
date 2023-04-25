package com.java.dto.request;

import java.sql.Date;

public class RequestVO {

	private String re_num;
	private String r_code;
	private String f_code;
	private Date re_date;
	private int re_qty;

	public RequestVO() {
	}

	public RequestVO(String re_num) {
		super();
		this.re_num = re_num;
	}

	public String getRe_num() {
		return re_num;
	}

	public void setRe_num(String re_num) {
		this.re_num = re_num;
	}

	public String getR_code() {
		return r_code;
	}

	public void setR_code(String r_code) {
		this.r_code = r_code;
	}

	public String getF_code() {
		return f_code;
	}

	public void setF_code(String f_code) {
		this.f_code = f_code;
	}

	public Date getRe_date() {
		return re_date;
	}

	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}

	public int getRe_qty() {
		return re_qty;
	}

	public void setRe_qty(int re_qty) {
		this.re_qty = re_qty;
	}

}
