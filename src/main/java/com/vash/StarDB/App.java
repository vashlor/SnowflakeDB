package com.vash.StarDB;

import java.sql.Connection;

public class App {
	public final static String FONT = "New Times Roman";
	private Connection conn = null;
	private LogIn login = null;
	
	public static void main(String[] args) {
		App app = new App();
	}
	
	public App(){
		if (login == null){
			login = new LogIn();
		}
		else {
			login.requestFocus();
		}
	}
	
	public void setConnection(Connection conn){
		this.conn = conn;
	}
	
	public Connection getConnection(){
		return conn;
	}
}

