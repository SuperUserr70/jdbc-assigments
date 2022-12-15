package com.Nbit.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.Nbit.utill.JdbcUtill;

public class InsertOpe {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter age:");
		int age = sc.nextInt();
		System.out.print("Enter email:");
		String email = sc.next();
		System.out.print("Enter location:");
		String loc = sc.next();
		try {
			connection = JdbcUtill.getConnection();
			String sql = "insert into user(`age`,`email`,`loction`) values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			if (preparedStatement != null) {
				preparedStatement.setInt(1, age);
				preparedStatement.setString(2, email);
				preparedStatement.setString(3, loc);
				
				
				int rows = preparedStatement.executeUpdate();
				System.out.println("No.of rows affected: "+rows);
			}
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtill.closeConnection(null, preparedStatement, connection);
		}
	}

}
