package com.Nbit.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.Nbit.utill.JdbcUtill;

public class UpdateOpe {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id:");
		int id = sc.nextInt();
		System.out.print("Enter new location:");
		String loc = sc.next();
		
		try {
			connection = JdbcUtill.getConnection();
			String sql = "update user set loction='"+loc+"' where id ="+id+"";
			preparedStatement = connection.prepareStatement(sql);
			int rows = preparedStatement.executeUpdate();
			System.out.println("no.of rows affected "+rows);
			
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtill.closeConnection(null, preparedStatement, connection);
		}
	}

}
