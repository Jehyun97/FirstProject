package com.java.dto.order;

import java.util.Date;

public class OrderVO {

	private String Ocode;
	private String Fcode;
	private String Snum;
	private Date Odate;
	private int Oqty;
	
	public OrderVO() {}
	
	public OrderVO(String Ocode) {
		super();
		this.Ocode =Ocode;
	}
	public String getOcode() {
		return Ocode;
	}
	public void setOcode(String ocode) {
		Ocode = ocode;
	}
	public String getFcode() {
		return Fcode;
	}
	public void setFcode(String fcode) {
		Fcode = fcode;
	}
	public String getSnum() {
		return Snum;
	}
	public void setSnum(String snum) {
		Snum = snum;
	}
	public Date getOdate() {
		return Odate;
	}
	public void setOdate(Date odate) {
		Odate = odate;
	}
	public int getOqty() {
		return Oqty;
	}
	public void setOqty(int oqty) {
		Oqty = oqty;
	}
	@Override
	public String toString() {
		return  Ocode+"\t\t"+Fcode+"\t\t"+Snum+"\t\t"+Odate+"\t"+Oqty+"\n";
	}
	
	
}
