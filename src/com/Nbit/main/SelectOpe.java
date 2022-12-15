package com.Nbit.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Nbit.utill.JdbcUtill;

public class SelectOpe {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtill.getConnection();
			String sql = "select age,email,loction from user";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Integer age = resultSet.getInt(1);
				String email = resultSet.getString(2);
				String location = resultSet.getString(3);
				System.out.println(age + "\t" + email + "\t" + location);

			}
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtill.closeConnection(resultSet, preparedStatement, connection);
		}

	}

}
