/*
 * Result Set: It is an object used to store sql query result executed using Statement , PreparedStatement , CallableStatement 
 * 
 * there are 3 uses of ResultSet
 * 
 * 1)Forward-Only : it is "Default" i.e. if not mention how we want to use ResultSet then rs is used as Forward-Only
 * 
 * 2)Scroll-Insensitive : Scroll means we can move forward as well as backward , Insensitive means once ResultSet is created , and there are some changes 
 * in Database ex: adding new record , updating value ,etc. this changes will not reflect in ResultSet.
 * 
 * 3)Scroll-Sensitive : Scroll means we can move forward as well as backward , Sensitive means once ResultSet is created , and there are some changes 
 * in Database ex: adding new record , updating value ,etc. this changes will reflect in ResultSet.
 * 
 * 
 * With ResultSet there is one more thing also which is Conncurrency Mode i.e. --> Parallely--> means the changes occured in database should
 * occur in ResultSet or not.
 * 
 * It has two types:
 * 
 * 1)CONCUR_READ_ONLY : used by Forward-Only and Scroll-Insensitive
 * 2)CONCUR_UPDATETABLE : used by and Scroll-Sensitive
 * 
 * 
 * 
 * 
 */

package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  //shift + ctrl + O
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemoScroll_Insensitive { 

	public static void main(String[] args) {

		
		Connection con = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;  // if result of any query comes in tabular form , then to store it in java we require class "ResultSet" and its object "rs"
		
		final String JDBC_URL = "jdbc:postgresql://localhost/ajdb20";
		final String JDBC_USERNAME = "root";
		final String JDBC_PASSWORD = "root@123";
		final String JDBC_DRIVER = "org.postgresql.Driver";
		
		
		try {
			
			Class.forName(JDBC_DRIVER);
			
			con = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME , JDBC_PASSWORD);
			
			//Scroll-Sensitive
			
			//using PreparedStatement class
			
			/*
			ps = con.prepareStatement("SELECT * FROM student" , ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY); 
			rs = ps.executeQuery(); 
			*/
			
			//using Statement class
			
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("Select * From student");
			
			
			System.out.println("*******FORWARD ONLY*******");
			
			
			while(rs.next()) {
				
				System.out.println("Roll Number :" + rs.getInt("rno"));
				System.out.println("Name :" + rs.getString("name"));          
				System.out.println("Percentage :" + rs.getDouble("per"));
				
				System.out.println("-----------------------------------------");
			
		   }
			
			System.out.println();
			
			System.out.println("\n*******BACKWARD ONLY*******\n");
			
			
			while(rs.previous()) {
				
				System.out.println("Roll Number :" + rs.getInt("rno"));
				System.out.println("Name :" + rs.getString("name"));          
				System.out.println("Percentage :" + rs.getDouble("per"));
				
				System.out.println("-----------------------------------------");
			
		   }
			
			System.out.println("\n*******RANDOM POSITION*******\n");

		   	rs.absolute(2);// 2 --> 2nd row in database
		   	System.out.println("Second Row - Roll no. :" + rs.getInt("rno") + "Name :" + rs.getString("name") +  rs.getDouble("per"));
		   	
		   	rs.first();
		   	System.out.println("First Row - Roll no. :" + rs.getInt("rno") + "Name :" + rs.getString("name") +  rs.getDouble("per"));
		   	
		   	rs.last();
		   	System.out.println("Last Row - Roll no. :" + rs.getInt("rno") + "Name :" + rs.getString("name") +  rs.getDouble("per"));
		   	
		   //	rs.deleteRow(); --> do not use this for Scroll-Insensitive because changes here will not be reflected in database in case of Scroll-Insensitive

			rs.close(); // to free memory of object that is pointing to records in the table
			con.close();
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			
			
		}
		
		
	}

}
