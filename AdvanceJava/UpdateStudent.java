package src.com.tca;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;            // instead of this import java.sql.*; will also work 
import java.sql.PreparedStatement;

public class UpdateStudent {
	
//	static final String JDBC_SERVER = "jdbc:postgresql://localhost/ajdb20";     // do like this while project development
//	static final String JDBC_USERNAME = "root";
//	static final String JDBC_PASSWORD = "root@123";
//	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	
	public static void main(String[] args) {
		
		Connection con = null;  // To form connection
		PreparedStatement ps = null; // To fire query 
		
		/*
		 * By creating connection we make a bridge between java application and database server 
		 * and by preparedstatement we can fire queries
		 */
		
		final String JDBC_SERVER = "jdbc:postgresql://localhost/ajdb20";
		final String JDBC_USERNAME = "root";
		final String JDBC_PASSWORD = "root@123";
		final String JDBC_DRIVER = "org.postgresql.Driver";
		
		/*
		 * 1)final because it will remain constant throughout the program , 
		 * and in java there is convention , any variable declared final should be in capital
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			//Step 1 --> Load Driver
			
			Class.forName(JDBC_DRIVER);  //---> ("Name of driver class")
			
			//Step 2 --> Forming Connection
			
			con = DriverManager.getConnection( JDBC_SERVER , JDBC_USERNAME , JDBC_PASSWORD );
			
			/*
			 * 1)when we go in company instead of local host , 198.09.09.12:8729 , 198.09.09.12-->IP address , 8729-->port no.
			 * 2)root --> username set at time of create role
			 * 3)root@123 ---> password set at time of create role
			 * 
			 * ajdb20-->database on which we are working
			 * postgresql --> database server we are using
			 * 
			 * DriverManager is a  class and getConnection is a static method of that class
			 * 
			 */
			
			System.out.print("Enter the Roll Number to delete record:");
			int rno = Integer.parseInt(br.readLine());
			
			System.out.print("Enter new name :");
			String name = br.readLine();
			
			System.out.print("Enter new Percentage :");
			double per = Double.parseDouble(br.readLine());
			
			//Step3 --> Prepare Sql
			
			ps = con.prepareStatement("UPDATE student SET name = ? ,per = ? WHERE rno = ?");  // 3 ? because our table has 3 columns , students is table name in our databse
			
			ps.setString( 1, name);
			ps.setDouble(2,per);
			ps.setInt(3, rno);  // 1st ? is for rno
			
			//Step4 --> Fire Sql
			
			int rval = ps.executeUpdate(); //The sql which we have made in 3rd step will get fired i.e. a record will be created
			
			if(rval == 0) { // rval = return value
				System.out.println("Record not found for roll no. :" + rno);
			}
			else {
				System.out.println("Record is updated succesfully !!! ");
			}
			
			//Step5 --> close connection 
			con.close();
			
		}
		
		catch(Exception e) {
			
			System.out.println("*** Problem in JDBC Application ***");
			e.printStackTrace();
			
		}

	}

}
