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

public class ResultSetDemoScroll_Sensitive_2 { 

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

			/*
			
		   	rs.absolute(4);// we are in 4th row in student table
		   	System.out.println("Fourth Row :" + rs.getInt(1) + " Name :" + rs.getString(2) + " Percentage :" + rs.getDouble(3)); // here 1,2,3 are respective columns in our database like 1st column is roll no. i.e. int
		    rs.updateString(2,"AMAN"); // 2nd column of 4th row in our data-base is name there change name to ANUJ
		    rs.updateDouble(3,89.26); // 3rd column of 4th row in our data-base is per there change per to 30.56
		    
		    rs.updateRow(); // when you fetch data i.e. making changes in database and reflecting here then use refreshRow();
		                    // when you do changes here and want to reflect changes done here in database then use updateRow();
		    
		    System.out.println("Record is updated for Roll Number :" + rs.getInt(1));
            //note - updated record gets added at last of table

		   	System.out.println("Fourth Row :" + rs.getInt(1) + " Name :" + rs.getString(2) + " Percentage :" + rs.getDouble(3)); // here 1,2,3 are respective columns in our database like 1st column is roll no. i.e. int

		    */
			
			rs.absolute(4);
			rs.deleteRow();
			System.out.println("Record is deleted");
			
			
			rs.close(); // to free memory of object that is pointing to records in the table
			con.close();
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			
			
		}
		
		
	}

}
