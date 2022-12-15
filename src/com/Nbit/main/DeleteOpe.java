package com.Nbit.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.Nbit.utill.JdbcUtill;

public class DeleteOpe {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id of user to delete:");
		int id = sc.nextInt();
		try {
			connection = JdbcUtill.getConnection();
			String query = "delete from user where id ='"+id+"'";
			preparedStatement = connection.prepareStatement(query);
			int rows = preparedStatement.executeUpdate();
			System.out.println("no,of rows deleted is: "+rows);

		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			JdbcUtill.closeConnection(null, preparedStatement, connection);
		}


	}

}
