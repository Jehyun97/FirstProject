package com.java.dto.restaurant;

public class RestaurantVO {
	
	private String rcode;
	private String rname;
	private String rphone;
	public RestaurantVO() {}

	public RestaurantVO(String rcode, String rname) {
		super();
		this.rcode = rcode;
		this.rname = rname;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRphone() {
		return rphone;
	}

	public void setRphone(String rphone) {
		this.rphone = rphone;
	}

	@Override
	public String toString() {
		return "{rcode=" + rcode + ", rname=" + rname + ", rphone=" + rphone + "}\n";
	}
	
	

}
