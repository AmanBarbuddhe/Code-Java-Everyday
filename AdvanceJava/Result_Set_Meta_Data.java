/*
     Q.What is ResultSetMetaDataSet?
     
     ---> Giving information about our table , like how many rows/columns are present in our table ,etc. this is called MetaData. 

	 Q.What is DatabaseMetaDataSet?
     
	 ---> To print information about database ,  database name , database version , ............... , List of tables name , etc.

*/

package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Result_Set_Meta_Data {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		final String JDBC_URL = "jdbc:postgresql://localhost/ajdb20";
		final String JDBC_USERNAME = "root";
		final String JDBC_PASSWORD = "root@123";
		final String JDBC_DRIVER = "org.postgresql.Driver";
		
		try {
			
			Class.forName(JDBC_DRIVER);
			
			con = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME , JDBC_PASSWORD);
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from student");
			
			rsmd = rs.getMetaData();
			
			int n = rsmd.getColumnCount();
			System.out.println("No. of Coumns : " + n);
			
			for(int i = 1 ; i <= n ; i++) {
				
				System.out.println("Column Name : " + rsmd.getColumnName(i));
				System.out.println("Column Type : " + rsmd.getColumnTypeName(i));

				
			}
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
