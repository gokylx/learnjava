package com.kylx.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DBUtil {
	
	private static final String  URL = "jdbc:mysql://127.0.0.1:3306/kylx?autoReconnect=true&useSSL=false";
	private static final String  USER = "root";	
	private static final String  PASSWORD = "password";
	
	private static Connection conn = null;
	static {
		try {
			// 1.������������
			Class.forName("com.mysql.jdbc.Driver");
			// 2.������ݿ������
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void main(String[] args) throws Exception {
		
		// 3.ͨ�����ݿ�����Ӳ������ݿ�
		
	}
}
