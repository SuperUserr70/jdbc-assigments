package com.Nbit.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.Nbit.utill.JdbcUtill;

public class JdbcDateRetrival {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name :");
		String name = sc.next();
		
		String sql = "select * from person where name = ?";
		
		try {
			connection = JdbcUtill.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("name :: "+resultSet.getString(2));
				System.out.println("address :: "+resultSet.getString(3));
				Date sdob =  resultSet.getDate(4);
				SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
				String dob = s.format(sdob);
				System.out.println("dob :: "+dob);
				
				Date sdoj = resultSet.getDate(6);
				SimpleDateFormat s1 =new SimpleDateFormat("MM-dd-yyyy");
				String doj = s1.format(sdoj);
				System.out.println("doj :: "+doj);
				
				System.out.println("dom :: "+resultSet.getDate(5));
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			JdbcUtill.closeConnection(resultSet, preparedStatement, connection);
		}

	}

}
