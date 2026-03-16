package com.tca;

import java.io.*;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  //shift + ctrl + O
import java.sql.ResultSet;

public class SearchStudent {

	public static void main(String[] args) {

		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;  
		
		final String JDBC_URL = "jdbc:postgresql://localhost/ajdb20";
		final String JDBC_USERNAME = "root";
		final String JDBC_PASSWORD = "root@123";
		final String JDBC_DRIVER = "org.postgresql.Driver";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		try {
			
			Class.forName(JDBC_DRIVER);
			
			con = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME , JDBC_PASSWORD);
			
			System.out.print("Enter the Roll Number to search :");
			int rno = Integer.parseInt(br.readLine());
			
			ps = con.prepareStatement("SELECT * FROM student WHERE rno = ?");  // by using this query rs will point towards only one entry
			
			ps.setInt(1 , rno);
			
			rs = ps.executeQuery(); 
			
			
			if(rs.next()) {
				
			 System.out.println("Record is found !!!");
			 System.out.println("Roll Number :" + rs.getInt("rno"));
			 System.out.println("Name :" + rs.getString("name"));          
			 System.out.println("Percentage :" + rs.getDouble("per"));
			 System.out.println("-----------------------------------------");
			}
			
			else {
				
			 System.out.println("No Record is found for Roll Number :" + rno);
				
			}
			}
			
		
		catch(Exception e) {
			
			e.printStackTrace();
			
			
		}
		
		
	}

}
