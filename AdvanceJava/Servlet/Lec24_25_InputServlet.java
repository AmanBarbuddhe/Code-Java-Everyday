/*
  How to create servlet? 
  
  File --> New --> Dynamic Web Project --> Java Resources --> src/main/java --> New Package --> com.tca --> New --> Servlet 
  --> in URL mapping by default name of file is there , remove it as we dont want file name to expose , and add there /user
  earlier it was file name i.e. UserServlet , after that uncheck constructor and doPost as our request method is GET 
  (specified in html form) i.e. only tick inherited abstract methods box and doGet box.
   
 
 
 
 
 
*/



package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");   // what is type of our response
		PrintWriter out = response.getWriter(); // out is the object of PrintWriter , used to write the response
		
		String un = request.getParameter("uname");  /*request is object that has the function getParameter which takes the 
												   	  value that has been entered on the html page , and in our html file 
													  we are taking input for User Name : and we identify it using "uname"*/
		
		
		//if(un.isEmpty())                                                                 | now we do not use this 
			//out.println("<h1> No Input Received </h1>"); // in case no input is entered  | because of html 5 properties , instead we use
		//else                                                                             | User Name : <input type="text" name="uname" required> <br>
			
		out.println("<h1> Hello," + un + "</h1>");  // printing the response
		
		out.close();                                // closing the resource
	}

}

/*
 
 http://localhost:8080/ASS02-GreetApplication/User.html
                       ----------------------
 								|
 						Server has many projects
 						running on it , this specifies
 						which project we are entertaining
 
 and ASS02-GreetApplication has : User.html , User.java , web.xml files 
 
 http://localhost:8080/ASS02-GreetApplication/User.html --> Request 1 --> URL-1
 http://localhost:8080/ASS02-GreetApplication/user --> Request 2 --> URL-2
 


                 client                                                                                                                      Server(Tomcat)
+------------------------------------------------------+                                                   			   +---------------------------------------------------+
|                                          			   |                                                   			   |                                                   |
|                                                      |                                                   			   |                                                   |
+------------------------------------------------------+                                                  			   +---------------------------------------------------+
|										   			   |	                        Request-1                          |                                                   |
|                                          			   |           Header                            Body              |                                                   |
|                                          			   |         +-----------------------------------------------+     |     											   |
|                                                      |		 |Sender IP address   URL-1|      Empty          |     |												   |
|                                          			   |         |Receiver IP address GET  |					 |     |         UserServlet.class                         |
|                                          			   |         +-----------------------------------------------+     |                  |                                |
|                                                      |-------------------------------------------------------------->|                  |                                |
|                                                      |															   |                doGet                              |
|                                                      |					       Response-1					       |    +---------------------------+                  |
|                                                      |<------------------------------------------------------------- |	|							|				   |
|                                                      |															   |    |                           |                  |
|                                                      |           Header           Body                               |    |                           |                  |
|                                                      |         +-------------------------------------------------+   |    |                           |                  |
|                                                      |		 |header same 	|User.html cha code		           |   |  request        	          response             |
|									                   |         |as time of    |							       |   |    |                           |                  |
| 							                           |         |request       |                                  |   |    |              				|				   |
|                                                      |         |              |                                  |   |    |                           |                  |
|                                                      |         +-------------------------------------------------+   |    |                           |                  |
|													   |															   | uname=Sachin	  			Hello,Sachin	       |	
|                                                      |                                                               |                                                   |
|                                                      | 															   |	                                               | 
|                                                      |      														   |	                                               |
|                                                      |                                                               |                                                   |
|                                                      |                                                               |                                                   |
|                                                      |                       Request-2                               |                                                   |
|                                                      |          Header                            Body               |                                                   |
|                                                      |        +-----------------------------------------------+      |                                                   |
|                                                      |        |Sender IP address   URL-2|uname = Sachin       |      |        										   |		   
|                                                      |        |Receiver IP address GET  |						|	   |		   										   |		  
|                                                      | 		+-----------------------------------------------+	   |												   |
|                                                      |-------------------------------------------------------------->|												   |
|                                                      |                                                               |                                                   |
|                                                      |                                                               |                                                   |
|                                                      |                       Response-2                              |                                                   |
|                                                      |<--------------------------------------------------------------|                                                   |
|                                                      |                                                               |                                                   |
|                                                      |          Header           Body                                |                                                   |
|                                                      |   +-------------------------------------------------+         |                                                   |
|                                                      |   |header same     |                                |         |												   |
|                                                      |   |as time of      | Hello,Sachin                   |         |												   |
|                                                      |   |request         |                                |         |                                                   |
|                                                      |   +-------------------------------------------------+	       |												   |
|                                                      |                                                               |                                                   |
+------------------------------------------------------+                                                               +---------------------------------------------------+




 
 
 --> When Request-1 strikes the server it sees the part ASS02-GreetApplication and brings this project to memory,
 	 then it sees this call is to User.html , as request is to html , servlet-engine directly sends the response,
 	 and User.html is picked and copied to response 
 
 
 
 
 After Request-1 and Response-1
 ------------------------------
  
 +--------------------------------------+
 |				+----------------+		|
 |	User Name : |				 |		|
 |				+----------------+		|
 |										|
 |+------+								|
 ||	Send |								|
 |+------+								|
 +--------------------------------------+
 
 This is visible on browser
 
 
--> Request 2 strikes to the server(Tomcat) , this request is generated when user enters User Name and hits Send  
    then on server it will notice that Request 2 has URL-2 that has /user , then server understands that this call is to servlet 
    but to which servlet? , there might be many "/user" in various servlet in the project , so this is specified in web.xml
    
  This is in web.xml
  
  <servlet>                                                                                                                                                                                                                                                                              
  	<servlet-name> UserServlet </servlet-name>        																																							     
  	<servlet-class> com.tca.UserServlet </servlet-class>   
  </servlet>																																																																		     
  																																																																						 	
  <servlet-mapping>                                          																																																							 	
  	<servlet-name> UserServlet </servlet-name> 					 																																																							 								
  	<url-pattern> /user </url-pattern>               																																																							 
  </servlet-mapping>  
 
 
 so when server sees "/user" in <servlet-mapping> it comes to know its in "UserServlet" then "<servlet> tag" sees if it has UserServlet and after finding it , "com.tca.UserServlet" i.e. the desired path is retrived and from there UserServlet.java is fetched
 
 so this is how server knows which servlet to call.......
 
 nowadays web.xml is not used instead annotations are used , but in background this is happening always
 
 --> UserServlet.java has doGet method this is identified from Header of Request-2 , there Request method is specified as GET
     therefore doGet is called and it has two objects (request,response) i.e. doGet(request,response)
     
 --> After response is written out.close() is done doGet cha execution sampte
 
 --> servlet-engines understands that execution of the request is done , then servlet-engine tells tomcat(server)
     that response for your request is generated i.e. here Hello,Sachin
    
 --> now tomcat starts preparing response by creating a packet     
 
 
 After Request-2 and Response-2
 ------------------------------
 
 +----------------------------+
 |                            |
 |							  |
 |Hello,Sachin 				  |
 |                            |  
 |                            |
 |                            |
 +----------------------------+
 
 
 This is displayed on Browser............
 
 */


//==================================================================================================================================================================================================================================================

/*

User.html File
--------------


<!-- to create html file in eclipse 

File -- New -- Dynamic Web Project -- src -- main -- right click on webapp -- new -- HTML file -- User.html

-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

															
	<form method="GET" action="./user">                      
		User Name : <input type="text" name="uname" required> <br>    
		
		<input type="submit" value="Send">                  
	</form>

</body>
</html>


<!-- method = "Get" so that it is exposed , action="./user" is link mapping and . means http://localhost:8080/ASS02-GreetApplication i.e.   ./user = http://localhost:8080/ASS02-GreetApplication/user -- >
<!-- User Name : this will appear on the form , it takes text as an input and it is identified with "uname" , "required" is used to add compulsion that this field must be filled-->
<!-- submit button is created which has "Send" written on it  -->
 
<!-- http://localhost:8080/ASS02-GreetApplication/User.html , by calling this we can see our html form where User.html is the form name  --> 
 
<!-- 
 
 +--------------------------------------+
 |				+----------------+		|
 |	User Name : |				 |		|
 |				+----------------+		|
 |										|
 |+------+								|
 ||	Send |								|
 |+------+								|
 +--------------------------------------+
 
 
-->
 
 
http://localhost:8080/ASS02-GreetApplication/user
--> this is the url when request method is POST

http://localhost:8080/ASS02-GreetApplication/user?uname=Aman
------------------------------------------------- ----------
                       |							   |
					  URL							 input
					  
--> this is the url when request method is GET , here our data(Aman) is getting exposed

 Therefore if dont want our data to get exposed in network then we use POST method

 Note : One servlet can have both GET and POST method
 ---- 
*/

























