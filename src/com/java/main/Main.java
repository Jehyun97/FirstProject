package com.java.main;

import com.java.controller.member.LoginController;

public class Main {
	private LoginController loginController = new LoginController();

	public static void main(String[] args) {	
		Main main = new Main();
		main.start();
	}
	
	public void start() {
		loginController.execute(null);
	}

}
