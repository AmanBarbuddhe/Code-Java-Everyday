/*
      Batch Update / Batch Processing
	  ===============================
	  
	  
	  ---> Batch updates in jdbc (java database connectivity) allow you to execute multiple sql statements in a single batch , 
	       improving performance by reducing the number of database calls.
	       
	  ---> This is especially useful when performing "repetitive operations" such as inserting , updating or deleting multiple records
	  
	  ---> It is used to improve the performance , in which a sequence is collected and submitted as a batch.
	    

			   java
		  application                                                                                  Database
		+------------+                         executeUpdate()                                    +----------------+
	  |            |      ------------------------------------------------------------------>   |                |
		|		         |							executeUpdate()                                               |                |
		|            |		------------------------------------------------------------------>     |                |
		|            |							executeUpdate()                                               |                |
	  | 			     |      ------------------------------------------------------------------>   |                |
		+------------+                                                                            |                |
                                                                                              +----------------+

								          Here we are executing each command individually 



						Instead we create a batch of all these three commands and then send it

			   java
		  application              BATCH                                                               Database
		+------------+         +----------+                                                       +----------------+
	  |            |         | c1 c2 c3 |                                                       |                |
		|		         |		     +----------+					              executeUpdate()                 |                |
		|            |		------------------------------------------------------------------>     |                |
		|            |							                                                              |                |
	  | 			     |                                                                            |                |
		+------------+                                                                            |                |
                                                                                              +----------------+

---------> as we are sending batch of three command we will get an array of size 3 telling the status of update
--------->i.e.                
								          0     1       2
											+-------------------+
					            |			 |     |      |		
											|	  1	 |	0	 |	3   |
											+-------------------+
													status

  0th index means 1st command(c1) updated 1 record
  1st index means 2nd command(c2) affected no record therefore 0
  2nd index means 3rd command(c3) affected 3 record therefore 3


  when we send record individually , it returns some value like UPDATE 1 and we store it in int rval , similarly now we are sending 3 commands at one time , therefore we will get an array of status 

*/


package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BatchUpdate_BatchProcessing {

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		Statement stmt = null;
		
		final String JDBC_URL = "jdbc:postgresql://localhost/studentdb";
		final String JDBC_USERNAME = "root";
		final String JDBC_PASSWORD = "root@123";
		final String JDBC_DRIVER = "org.postgresql.Driver";
		
		
		try {
			
            Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME , JDBC_PASSWORD);
			
			con.setAutoCommit(false);
			
			stmt = con.createStatement();
			
			/*                                                                // returns 
			stmt.addBatch("insert into student values(101,'AAA',89)");         //   1
			stmt.addBatch("insert into student values(102,'BBB',59)");         //   1
			stmt.addBatch("insert into student values(103,'CCC',75)");         //   1   
			*/
			
			                                                                  // returns 
			stmt.addBatch("insert into student values(105,'DDD',90)");       //   1
			stmt.addBatch("delete from student where rno = 107");            //   0
			stmt.addBatch("update student set per = 99 where per>=80");      //   2   
			

			int sval [] = stmt.executeBatch();  // executeBatch(); ---> this will return array 
			
			System.out.println("Status : " + Arrays.toString(sval));
			
			con.commit();   //  --> if commit is not there then the changes done here will not be reflected in database , therefore to reflect in database commit should be there , earlier we were not using commit still changes were reflected in database , because by default commit is true always
			con.close();
			System.out.println("Operation is Successfull !!!");
			
		}
		
		catch(Exception e) {
			
			System.out.println("Operation is Failed !!!");
			
			con.rollback();
			e.printStackTrace();
			
		}

	}

}
