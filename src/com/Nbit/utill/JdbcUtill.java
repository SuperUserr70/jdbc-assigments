package com.Nbit.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtill {
	
	private JdbcUtill() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/data1";
		String username = "root";
		String password = "Praveen@2022";
		Connection connection = null;
		connection = DriverManager.getConnection(url, username, password);
		
		if (connection != null) 
			return connection;
		return connection;
		
	}
	
	public static void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection)
			throws SQLException {

		// 6. closing the resources used
		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();

		}
		if (connection != null) {
			connection.close();
		}

	}

}
