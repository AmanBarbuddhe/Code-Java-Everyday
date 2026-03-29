package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddNStudents {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final String JDBC_URL = "jdbc:postgresql://localhost/ajdb20";
		final String JDBC_USERNAME = "root";
		final String JDBC_PASSWORD = "root@123";
		final String JDBC_DRIVER = "org.postgresql.Driver";
		
		try {
		
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME , JDBC_PASSWORD);
			
			ps = con.prepareStatement("Insert into student values(?,?,?)"); 
			
			
			/* by writing PreparedStatement outside the loop you ensure that translation is done only one time
			 *  
			 * translation --> converts sql query into binary form
			 * 
			 * DB engine translates sql query and executes it and response/output is given
			 * 
			 *         java application                                  before communicating to database we have to go through dbms
			 *     -------------------------                            ---------------------------
  			 *    |                         |       sql query           |    D   |                 |
			 *    |                         |     --------------------->|    B   |                 |
			 *    |                         |     <---------------------|    M   |                 |
			 *    |                         |          response/output  |    S   | Database        |
			 *     -------------------------                            |        |                 |
			 *                                                          |  T+E   |                 |
			 *                                                          |        |                 |
			 *                                                           ---------------------------
			 *                                                               ^
			 *                                                               |
			 *                                                          DB Engine
			 *                                                           
			 *                                                           
			 *if we execute while loop for n entries and write "ps = con.prepareStatement("Insert into student values(?,?,?)");" then it will get translated 
             *and executed n times , but if we write "ps = con.prepareStatement("Insert into student values(?,?,?)");" outside the loop then ,
             *translation decreases from n to 1 however execution is done n times                 
			 *                                                           
			 *                                                           
			 *                                                           
			 */
			
			/*
			 * Similarity : Prepared Statement and Statement both classes are used to execute sql statements
			 * 
			 *              PreparedStatement                                         |                        Statement
			 *                                                                        |
			 *   1) Dynamic Sql                                                       |    1)Static Sql
			 *   i.e. ps = con.prepareStatement("Insert into student values(?,?,?)"); |    i.e. Statement stmt = con.createStatement();
			 *                                                                        |    stmt.executeUpdate("insert into student(101 , 'AAA' , 60)")
			 *                                                                        |
			 *   2)Prepared statement are said to be precompiled sql statement        |    2)No precompiled 
			 *   i.e. translation is done only once and used always                   |    i.e. translation is done always
			 *                                                                        |
			 *   3)PreparedStatement is used when we want to execute                  |    3)here values have to be given manually
			 *   parameterized sql queries i.e. ---> (?,?,?)                          |
			 *                                                                        |
			 *   4)It is used when we want to execute single                          |    4)It is used when we want to execute query only once
			 *   query multiple times
			 * 
			 */
			
			
			while(true) {
				
				System.out.print("Enter the Roll Number :");
				int rno = Integer.parseInt(br.readLine());
				
				System.out.print("Enter Name :");
				String name = br.readLine(); //no need of converstion
				
				System.out.print("Enter Percentage :");
				double per = Double.parseDouble(br.readLine());
				
				ps.setInt(1 , rno);  // 1st ? is for rno
				ps.setString(2 , name);
				ps.setDouble(3 , per);
				
				int rval = ps.executeUpdate();
				
				System.out.print("Do you want to continue [Yes/No] :");
				
				String option = br.readLine();
				
				if(option.equalsIgnoreCase("yes")) {
					continue; // takes you at the beginning of the loop
				}
				
				else {
					break; // loop ends until that loop will go on as long as required and we want that only therefore we have used while loop here
				}
				
			}
			
			System.out.println("Records Saved Successfully !!!!");
			
			con.close();
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
