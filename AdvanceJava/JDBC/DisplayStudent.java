package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  //shift + ctrl + O
import java.sql.ResultSet;

public class DisplayStudent {

	public static void main(String[] args) {

		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;  // if result of any query comes in tabular form , then to store it in java we require class "ResultSet" and its object "rs"
		
		final String JDBC_URL = "jdbc:postgresql://localhost/ajdb20";
		final String JDBC_USERNAME = "root";
		final String JDBC_PASSWORD = "root@123";
		final String JDBC_DRIVER = "org.postgresql.Driver";
		
		
		try {
			
			Class.forName(JDBC_DRIVER);
			
			con = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME , JDBC_PASSWORD);
			
			ps = con.prepareStatement("SELECT * FROM student");
			
			rs = ps.executeQuery(); 
			
			
			
			/*
			 * in before assignment we were using ps.executeUpdate(); but here we are using ps.executeQuery(); why?
			 * 
			 * ps.executeUpdate(); is used for DML queries i.e. INSERT , DELETE , UPDATE because this queries makes changes in the table
			 * 
			 * if any other query the use ps.executeQuery(); 
			 * 
			 * and as DML commands returns some changes we were using int rval in earlier assignments
			 * 
			 * but here we are storing all the result set of the query "SELECT * FROM student"
			 * 
			 * and rs of this query is ----->
			 * 
			 *                        rno | name | per
                                     -----+------+-----
                             rs --->  101 | AAA  |  90
                                      102 | BBB  |  87
                                      103 | DDD  |  93
			*/
			
			
			
			/*
			  while(rs.next()) sees if there is a next record if yes then TRUE if not Then FALSE
			  
			  
			  	                      rno | name | per
                                     -----+------+-----    rs.next means rs chya samor konta record aahe ka....... not after where currently rs is pointing
                             rs --->  101 | AAA  |  90
                                      102 | BBB  |  87
                                      103 | DDD  |  93
                                      
                             yes next record exist , executes code in java and moves to next record
                             
                                      rno | name | per
                                     -----+------+-----
                                      101 | AAA  |  90
                            rs--->    102 | BBB  |  87
                                      103 | DDD  |  93
			  
			  
			 
			  */
			
			 /*
			  * here we have used query "SELECT * FROM student"
			  * that by default is in the order rno , name , per
			  * 
			  * but if we have write "SELECT name , rno , per FROM student" or if we want to print only 2 record or say one record then
			  * SELECT name , rno FROM student or SELECT name FROM student then we will have to make changes accordingly
			  * 
			  * therefore we should use this:
			  * 
			  * System.out.println("Roll Number :" + rs.getInt(rno));
				System.out.println("Percentage :" + rs.getDouble(per));
				System.out.println("Name :" + rs.getString(name));
				
				instead of this :
				
				System.out.println("Roll Number :" + rs.getInt(1));
				System.out.println("Name :" + rs.getString(2));
				System.out.println("Percentage :" + rs.getDouble(3));
				
				because here we will have to be carefull about numbering
				
			  * 
			  */
			
			
			
			
			
			

			
			
			while(rs.next()) {
				
				/*
				 * as our query is "SELECT * FROM student" and our column is rno , name , per
				 * 
				 * therefore 1-->rno , 2-->name , 3-->per
				 * 
				*/
				
				System.out.println("Roll Number :" + rs.getInt(1));
				System.out.println("Name :" + rs.getString(2));
				System.out.println("Percentage :" + rs.getDouble(3));
				System.out.println("-----------------------------------------");
				
				//rno , name , per are name of column in our database , and order can be different as we give positioning
				
			/*
			 * 
			 *  this is used because if there is a huge table then humans cannot remember numbers but they can remember names
			 * 
				System.out.println("Roll Number :" + rs.getInt("rno"));
				System.out.println("Name :" + rs.getString("name"));          
				System.out.println("Percentage :" + rs.getDouble("per"));
				System.out.println("-----------------------------------------");
			
				rno , name , per are name of column in our database , and order can be different as we give positioning
			    ex:
			    
			    System.out.println("Roll Number :" + rs.getInt("rno"));
				System.out.println("Percentage :" + rs.getDouble("per"));
				System.out.println("Name :" + rs.getString("name"));
			
			*/	
				
				
				
			}
			
			rs.close(); // to free memory of object that is pointing to records in the table
			con.close();
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			
			
		}
		
		
	}

}
