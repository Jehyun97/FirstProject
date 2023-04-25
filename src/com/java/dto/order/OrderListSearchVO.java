package com.java.dto.order;

import java.sql.Date;

public class OrderListSearchVO {
	
	private String Ocode;
	private String Fcode;
	private String Snum;
	private Date Odate;
	private int Oqty;
	private String Fname;
	private String Wname;
	
	


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

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getWname() {
		return Wname;
	}

	public void setWname(String wname) {
		Wname = wname;
	}

	@Override
	public String toString() {
		return 	Odate+"\t"+Ocode+"\t\t"+Fname+"\t\t"+Oqty+"\t"+Wname+"\t\t"+Snum+"\n";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
