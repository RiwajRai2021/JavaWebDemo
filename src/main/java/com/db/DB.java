package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
	public static Connection getDbObject() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3307/webDB", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;   
		
	}

}
