package com.Nbit.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.Nbit.utill.JdbcUtill;

public class JdbcDateInsert {

	public static void main(String[] args) throws ParseException, SQLException {
		Connection connection = null;
		PreparedStatement pstm = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name :");
		String name = sc.next();
		
		System.out.print("Enter address :");
		String address = sc.next();
		
		System.out.print("Enter dob (dd-mm-yyyy) :");
		String dob = sc.next();
		
		System.out.print("Enter doj (MM-dd-yyyy) :");
		String doj = sc.next();
		
		System.out.print("Enter dom(yyyy-MM-dd) :");
		String dom = sc.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date udate = sdf.parse(dob);
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		Date d = sdf1.parse(doj);
		
		
		Long time = udate.getTime();
		java.sql.Date sdob = new java.sql.Date(time);
		
		Long time1 = d.getTime();
		java.sql.Date sdoj = new java.sql.Date(time1);
		
		java.sql.Date sdom =java.sql.Date.valueOf(dom); 
		
		String sql = "insert into person(`name`,`address`,`dob`,`doj`,`dom`) values(?,?,?,?,?)";
		try {
			connection = JdbcUtill.getConnection();
			pstm = connection.prepareStatement(sql);
			pstm.setString(1,name);
			pstm.setString(2, address);
			pstm.setDate(3, sdob);
			pstm.setDate(4, sdoj);
			pstm.setDate(5, sdom);
			
			int rows = pstm.executeUpdate();
			System.out.println("rows affected "+rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtill.closeConnection(null, pstm, connection);
		}
		

	}

}
