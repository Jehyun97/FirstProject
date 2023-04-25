package com.java.views;

import java.util.Map;

public abstract class View {

	private String menu;

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getMenu() {
		return menu;
	}

	public abstract Map<String, Object> view(Map<String, Object> param);

}
