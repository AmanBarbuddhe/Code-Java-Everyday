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

  /*
   use case ---> in cricket match as soon as ball is balled , changes are automatically reflected in scoreboard , without refreshing the page 
   this is because change has been done in database which is getting reflected on scoreboard.
  */




package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  //shift + ctrl + O
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemoScroll_Sensitive_1 { 

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
			
			//Scroll-Insensitive
			
			//using PreparedStatement class
			
			/*
			ps = con.prepareStatement("SELECT * FROM student" , ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE); 
			rs = ps.executeQuery(); 
			*/
			
			//using Statement class
			
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("Select * From student");
			
			
			System.out.println("*******FORWARD ONLY*******");
			
			
			while(rs.next()) {
				
				System.out.println("Roll Number :" + rs.getInt("rno"));
				System.out.println("Name :" + rs.getString("name"));          
				System.out.println("Percentage :" + rs.getDouble("per"));
				
				System.out.println("-----------------------------------------");
			
		   }
			
			
			System.out.println("\n*******BACKWARD ONLY*******\n");
			
			
			while(rs.previous()) {
				
				System.out.println("Roll Number :" + rs.getInt("rno"));
				System.out.println("Name :" + rs.getString("name"));          
				System.out.println("Percentage :" + rs.getDouble("per"));
				
				System.out.println("-----------------------------------------");
			
		   }
			
			System.out.println("\n*******RANDOM POSITION*******\n");

		   	rs.absolute(1);// 1 --> 1st row in database
		   	System.out.println("BEFORE ----> First Row - Roll no. :" + rs.getInt("rno") + " Name :" + rs.getString("name") +  " Percentage :" + rs.getDouble("per"));
		   	
		   	System.out.print("Press any key to continue....");
		   	System.in.read();  // this is to stop code so that we can make changes in database meanwhile , and after giving any input code will resume
		   	
		   	rs.refreshRow(); // now as we have made changes in database , it should reflect here for that row should be refreshed
		   	System.out.println("AFTER ----> First Row - Roll no. :" + rs.getInt("rno") + " Name :" + rs.getString("name") + " Percentage :" +  rs.getDouble("per"));

            //note - updated record gets added at last of table

		   	
			rs.close(); // to free memory of object that is pointing to records in the table
			con.close();
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			
			
		}
		
		
	}

}
