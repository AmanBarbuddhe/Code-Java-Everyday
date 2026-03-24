/*
 

	 Q.What is DatabaseMetaDataSet?
     
	 ---> To print information about database ,  database name , database version , ............... , List of tables name , etc.

*/

package com.tca;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Database_Meta_Data {

	public static void main(String[] args) {

		Connection con = null;
		DatabaseMetaData dbmd = null;
		ResultSet rs = null;
		
		final String JDBC_URL = "jdbc:postgresql://localhost/ajdb20";
		final String JDBC_USERNAME = "root";
		final String JDBC_PASSWORD = "root@123";
		final String JDBC_DRIVER = "org.postgresql.Driver";
		
		try {
			
			Class.forName(JDBC_DRIVER);
			
			con = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME , JDBC_PASSWORD);
			
			dbmd = con.getMetaData();
			
			System.out.println("**************** DATABASE INFORMATION ****************");
			
			System.out.println();

			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getUserName());

			System.out.println();
			System.out.println("---------------------------------------------------------------------");
			
			System.out.println();
			System.out.println("**************** DATABASE INSIDE INFORMATION ****************");
			
			System.out.println();
			
			System.out.println("List of Table : ");
			rs = dbmd.getTables(null , null , null , new String[] {"TABLE"});
			
			while(rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
			
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
