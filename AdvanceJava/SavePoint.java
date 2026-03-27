/*
in DBMS there is a concept called "CheckPoint" , it acts as a boundry to tell till where should a program be "Rolled Back" on occurrence of a failure
as there is no need to recalculate everything when failure occured , some calculations/operation are right and after that failure is occured , so no need
to recalculate them

to do the same java has class called "SavePoint"

SavePoint : ----> It is used to mark one or more places in transaction
			----> As one transaction can have multiple save points , so if needed you can perform rollback to one of those SavePoint.


*/




package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointDemo {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		
		final String JDBC_URL = "jdbc:postgresql://localhost/ajdb20";
		final String JDBC_USERNAME = "root";
		final String JDBC_PASSWORD = "root@123";
		final String JDBC_DRIVER = "org.postgresql.Driver";
		
		try {
			
		
			Class.forName(JDBC_DRIVER);
			
			con = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME , JDBC_PASSWORD);
			
			stmt = con.createStatement();
			
			con.setAutoCommit(false);
			
            String cmd1 = "INSERT INTO student VALUES (1, 'Aman')";
            String cmd2 = "INSERT INTO student VALUES (2, 'Rahul')";
            String cmd3 = "INSERT INTO student VALUES (3, 'Neha')";
            String cmd4 = "UPDATE student SET name='Updated1' WHERE rno=4";
            String cmd5 = "UPDATE student SET name='Updated2' WHERE rno=5";
            
            stmt.executeUpdate(cmd1);
            stmt.executeUpdate(cmd2);
            stmt.executeUpdate(cmd3);
            
            Savepoint pt1 = con.setSavepoint("SavePoint1");
            
            int i = stmt.executeUpdate(cmd4);
            int j = stmt.executeUpdate(cmd5);
            
            if(i==0){       // if after updating we get msg like "UPDATE 0" ==> failure i.e. no updation because might be the field you want to update in , is not there or any other reason"
            			   // and if msg comes "UPDATE 1" ==> one field is updated , "UPDATE 2" ==> 2 fields are updated , etc , etc.
            			  // so we are checking for that 0(the one which comes on failure while updation) here in i and j
            	
            	System.out.println("RollBack to starting");
            	con.rollback();                                 // role back to starting
            } 
            if(j==0)
            { 
            	System.out.println("RollBack to SavePoint , and execute all statements below it");
            	con.rollback(pt1);                              // role back to save point
            }
		
		
            con.commit();
            con.close();
		
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
