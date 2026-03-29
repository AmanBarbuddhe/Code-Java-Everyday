/*
===========
TRANSACTION
===========

                                       Table-->        Account
                                                acc_no.  name  balance
                                              --------------------------
                              Account of A -->   101      AAA   10000 
                              Account of B -->   102      BBB   7000
                            
              
               
               Transaction
              -------------
Read From A	-->		R(A)	
                 A = A - 500;      A = 10000 - 500 = 9500
Write in A  -->     W(A)        

Read From B	-->     R(B)
				 B = B + 500;      B = 7000 + 500 = 7500
Write in A  -->     W(B)

				   Commit       ----> After doing commit the changes made here are reflected in database


							           Table-->         Account
                                                acc_no.  name  balance
                                              --------------------------
                              Account of A -->   101      AAA   9500 
                              Account of B -->   102      BBB   7500
                              
                              
    On Database How this executed?
    
    UPDATE Account SET balance = balance - 500 WHERE acc_no. = 101
    UPDATE Account SET balance = balance + 500 WHERE acc_no. = 102
           
   
    Transaction ---> When performing one or more than one database operations as a "single unit" is called Transaction
    ===========                          

	RollBack ----> if failures occures during transaction then changes are not made permanent as the execution doesnt reach till "Commit"
	         ----> in above example  , A = A - 500 => A = 9500 then due to some reasons failure occurs and therefore there is RollBack and A becomes A = 10000 again


	Note: By default in JDBC application Auto Commit is true , i.e. after executing some transaction commit will be done automatically doesnt matter exception comes
	later , changes will be reflected in database
	
	***************** Before Setting Auto-Commit to false *****************
	
	ex:
	
	try {
			
			Class.forName(JDBC_DRIVER);
			
			con = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME , JDBC_PASSWORD);
			
			ps1 = con.prepareStatement("UPDATE account SET balance = balance - 500 WHERE acc_no = 101");
			ps1.executeUpdate();
			
			Integer.parseInt("INDIA"); // this line is written to generate exception so that our codes to catch block and program terminates
			
			ps2 = con.prepareStatement("UPDATE account SET balance = balance + 500 WHERE acc_no = 102");
			ps2.executeUpdate();
			
			con.close();
			
			System.out.println("Amount Transferred Successfully !!!!!");
			
			
		}
		
		catch(Exception e) {
			
			System.out.println("Transaction Failded...........");
			e.printStackTrace();
			
		}
		
		In the Console : 
		================
		
		Transaction Failded...........
		java.lang.NumberFormatException: For input string: "INDIA"
		at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
		at java.base/java.lang.Integer.parseInt(Integer.java:662)
		at java.base/java.lang.Integer.parseInt(Integer.java:778)
		at com.tca.JDBC_TransactionDemo.main(JDBC_TransactionDemo.java:78)
	
		At Database Side:
		=================
		
		 acc_no | name | balance
		--------+------+---------
    		102 | BBB  |    7000
    		101 | AAA  |    9500
		
		# Exception came after 1st update and it got Auto-Commit and 2nd update did not execute because after exception occured code was in catch block
	

	


*/

package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_TransactionDemo {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		
		final String JDBC_URL = "jdbc:postgresql://localhost/ajdb20";
		final String JDBC_USERNAME = "root";
		final String JDBC_PASSWORD = "root@123";
		final String JDBC_DRIVER = "org.postgresql.Driver";
		
		try {
			
			Class.forName(JDBC_DRIVER);
			
			con = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME , JDBC_PASSWORD);
			
			con.setAutoCommit(false); // to set auto commit to false , now commit will be done on programmers desire
			
			ps1 = con.prepareStatement("UPDATE account SET balance = balance - 500 WHERE acc_no = 101");
			ps1.executeUpdate();
			
			Integer.parseInt("INDIA"); // this line is written to generate exception so that our codes to catch block and program terminates
			
			ps2 = con.prepareStatement("UPDATE account SET balance = balance + 500 WHERE acc_no = 102");
			ps2.executeUpdate();
			
			con.commit();  // we set auto-commit to false , then by declaring here con.commit() we are giving the location where commit() has to be executed
			con.close();
			
			System.out.println("Amount Transferred Successfully !!!!!");
			
			
		}
		
		/*
		
		***************** After setting auto commit to false and giving location where to ececute "commit" by con.commit(); *****************
		
		In the Console : 
		================
		Transaction Failded...........
		java.lang.NumberFormatException: For input string: "INDIA"
		at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
		at java.base/java.lang.Integer.parseInt(Integer.java:662)
		at java.base/java.lang.Integer.parseInt(Integer.java:778)
		at com.tca.JDBC_TransactionDemo.main(JDBC_TransactionDemo.java:137)

		At Database Side:
		=================
		
		 acc_no | name | balance
		--------+------+---------
    		101 | AAA  |   10000
    		102 | BBB  |    7000
		
		--> No change in database
		
		
		
		*/
		
		catch(Exception e) {
			
			System.out.println("Transaction Failded...........");
			
			try 
			{
				con.rollback();        // con.rollback(); gives exception therefore try catch is added , Writing EXCEPTION in front of main function would also have worked
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			
			}
			
			e.printStackTrace();
			
		}

		
	}

}
