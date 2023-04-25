package com.java.dto.food;

public class FoodVO {

	private String fcode;
	private String fname;
	private String forigin;
	private String fallergy;
	private String fcategory;
	private String fmethod;
	private String funit;

	public FoodVO() {
	}

	public FoodVO(String fcode, String fname) {
		super();
		this.fcode = fcode;
		this.fname = fname;
	}

	public String getFcode() {
		return fcode;
	}

	public void setFcode(String fcode) {
		this.fcode = fcode;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getForigin() {
		return forigin;
	}

	public void setForigin(String forigin) {
		this.forigin = forigin;
	}

	public String getFallergy() {
		return fallergy;
	}

	public void setFallergy(String fallergy) {
		this.fallergy = fallergy;
	}

	public String getFcategory() {
		return fcategory;
	}

	public void setFcategory(String fcategory) {
		this.fcategory = fcategory;
	}

	public String getFmethod() {
		return fmethod;
	}

	public void setFmethod(String fmethod) {
		this.fmethod = fmethod;
	}

	public String getFunit() {
		return funit;
	}

	public void setFunit(String funit) {
		this.funit = funit;
	}

	@Override
	public String toString() {
		return "{fcode=" + fcode + ", fname=" + fname + ", forigin=" + forigin + ", fallergy=" + fallergy
				+ ", fcategory=" + fcategory + ", fmethod=" + fmethod + ", funit=" + funit + "}\n";
	}

}