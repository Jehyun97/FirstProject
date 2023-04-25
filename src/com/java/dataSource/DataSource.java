package com.java.dataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {

	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String username = "2team";
	private String password = "2team";

	private static DataSource instance = new DataSource();
	private DataSource() {}
	public static DataSource getInstance() {
		return instance;
	}
	{
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection()throws Exception{
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	
	

	public void setIP(String ip) {
		this.url.replace("localhost", ip);
	}

	public String getIp() {
		int index = this.url.indexOf("@");
		String temp = this.url.substring(index + 1);

		index = this.url.indexOf(":");
		String ip = temp.substring(0, index);

		return ip;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}