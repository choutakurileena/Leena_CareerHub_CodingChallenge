package com.careerhub.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.careerhub.exception.DatabaseConnectionException;

public class DBUtil {
	private static Connection connection;
	 
	public static Connection createConnection() throws DatabaseConnectionException {
		ResourceBundle resMySQL = ResourceBundle.getBundle("mysql");
 
		String url = resMySQL.getString("url");
		String username = resMySQL.getString("username");
		String password = resMySQL.getString("password");
		String driver = resMySQL.getString("driver");
 
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Loading JDBC driver into memory
 
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseConnectionException(e.getMessage());
		}
		System.out.println("Connection established.");
		return connection;
	}
 
	public static void closeConnection() throws SQLException {
		connection.close();
	}
}