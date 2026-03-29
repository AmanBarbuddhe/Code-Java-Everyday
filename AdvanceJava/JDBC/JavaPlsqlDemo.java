/*
    CallableStatement is used when we want to execute PLSQL statements from Java Application.

	What is PLSQL?
	==============
	
	-----> PLSQL stands for Procedural Structured Query Language
	-----> If you are writing variable , if-else , loops , functions in a query language , is called PLSQL

	How to write PLSQL codes
	========================
	
	Q. Write a method which returns "Hello World"
	
	String msg(){
	
	   return "Hello World";
	
	}
	
	
	PLSQL CODE
	==========
	
	CREATE OR REPLACE FUNCTION msg()      // msg() ---> function name 
	RETURNS VARCHAR AS'                    // we want to return Hello World therefore ---> VARCHAR
	BEGIN                                  // open curly bracket
		return ''Hello World'';            //     "--> not this , single quote(') two times
	END ;                                  //close curly bracket
	'LANGUAGE 'plpgsql';   

	put this whole PLSQL CODE on shell(psql) and to call the function write "  SELECT msg()  "

	--------------------------------------------------------------------------
	SELECT msg() AS Message_from_method;  -----> to rename the function name
	
	DROP FUNCTION msg() ----> to delete the function
	---------------------------------------------------------------------------

	Q. Addition of two numbers
	
	int add(int a , int b){
	
		int c;             // local variable
		c = a + b ;
		return c;
	
	}


	PLSQL CODE
	==========
	
	CREATE OR REPLACE FUNCTION add( a int , b int )
	RETURNS int AS'
	DECLARE 
		c int := 0;                 // this is how local variable is declared in PLSQL , and initialized to 0 to avoid garbage value
	BEGIN
		c = a + b ;
		return c;
	END;
	'LANGUAGE 'plpgsql'; 

	to call this function ----> SELECT add(3,5);
	
	
	Q. Write a add info method which will save students record
	
	CREATE OR REPLACE FUNCTION addinfo(	r int , nm varchar , p float)
	RETURNS varchar AS'
	BEGIN
		insert into student values(r,nm,p);
		return ''Record Saved Successfully !!'';
	END;
	'LANGUAGE 'plpgsql';


*/


package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JavaPlsqlDemo {

	public static void main(String[] args) {
	
			
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		final String JDBC_URL = "jdbc:postgresql://localhost/ajdb20";
		final String JDBC_USERNAME = "root";
		final String JDBC_PASSWORD = "root@123";
		final String JDBC_DRIVER = "org.postgresql.Driver";
		
		
		try {
			
			
			Class.forName(JDBC_DRIVER);
			
			con = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME , JDBC_PASSWORD);
			
			//ps = con.prepareStatement("SELECT msg()");   //---> to call function made in database
			
			ps = con.prepareStatement("SELECT addinfo(106,'FFF',74)");
			
			rs = ps.executeQuery();
			
			rs.next();
			
			// System.out.println("Output : " + rs.getString(1));   // Output : Hello World ------> it is for msg function
			
			//to get output of addinfo
			System.out.println("Output : " + rs.getString("addinfo"));     // for rno also rs.getString() will work because System.out.println converts anything into a string 

			//rs.getString(1) ---> it also work , actually it is the function whos column name is addinfo and has only one record i.e. Output : Record Saved Successfully !!
			
			/*
			
			
			           addinfo                  equivaent to                rno
			  ------------------------------							------------
 				Record Saved Successfully !!								103        for this we would have written ---> rs.getString("rno") or rs.getString(1)
			
			
			
			*/
			
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
