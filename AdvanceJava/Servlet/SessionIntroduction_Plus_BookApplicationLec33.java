/*

    Servlet has two objects request and response


            Client                                                                 Server
    +--------------------+               Request 1                   +-------------------------------------+
    |                    |------------------------------------------>|              Servlet                |
    |                    |<------------------------------------------|  Request 1             Response 1   |    --> Request 1 and Response 1 gets destroyed after response is send i.e. server doesnt know previous request was because of whom  -->|
    |                    |               Response 1                  |                                     |                                                                                                                                        |        
    |                    |                                           |                                     |                                                                                                                                        |--> While server is giving response to current request , it does not remembers previous requests because "HTTP is a stateless protocol"                                                               
    |                    |               Request 2                   |                                     |                                                                                                                                        |
    |                    |------------------------------------------>| Request 2              Response 2   |    --> Request 2 and Response 2 gets destroyed after response is send i.e. server doesnt know previous request was because of whom  -->|
    |                    |<------------------------------------------|                                     |
    |                    |               Response 2                  |                                     |
    |                    |                                           |                                     |
    |                    |               Response 3                  |                                     |
    |                    |------------------------------------------>| Request 3              Response 3   |
    |                    |<------------------------------------------|                                     |
    |                    |               Response 3                  |                                     |
    |                    |                                           |                                     |
    |                    |                                           |                                     |
    +--------------------+                                           +-------------------------------------+

                                                                        key            value                  
                                                                     +-------------------------------------+
                                                                     |                                     |
                                                                     |  Request 1     Request 2            |
                                                                     |                                     |
                                                                     |                                     |
                                                                     +-------------------------------------+
                                                                                    Session                 ---> so to remember previous requests(from login to getting logged in) we have sessions which are saved at server side (cookies were saved at client side)                         



            usecase : in myntra , Request 1 for shoes , Request 2 for shirts , Request 3 for pants

*/


/*

Above was the overview about what is session? , Below is the Architecture of the application that we are making

        Page1.html                                                                Page2Servlet.java                                                       Page3Servlet.java
+-------------------------------+                                          +-------------------------------+                                    +----------------------------------------------+
|								|                                          |1.Create Session               |                                    | Use existing session to retrive              |
|	PAGE 1 LANGUAGES BOOK		|                                          |2.Store the Data that came with|                                    | page1 total(ltotal) that was saved in        |
|								|                                          |  Request into Session         |                                    | page2 and here calculate page2 total(sjtotal)|
|	Select Books	        	|       Request + (200+550)                |-------------------------------+     Request + (300)                |----------------------------------------------|
|								|----------------------------------------->|  Second-Form                  |----------------------------------->|       BILL                                   |
|	+--+						|                                          |-------------------------------|                                    |                                              |
|	|  |  C Rs. 150				|                                          |  PAGE 2 SERVLET & JSP BOOK    |                                    |       Page 1            : Rs.750             |
|	+--+						|                                          |  Select Books                 |                                    |       Page 2            : Rs.300             |
|								|                                          |  +--+                         |                                    |       Total Bill Amount : Rs.1050	       	   |
|	+--+						|                                          |  |  |   BOOK1 Rs. 450         |                                    |----------------------------------------------|
|	| .|  C++ Rs. 200			|                                          |  +--+                         |                                    |        Destroy Session :                     | 
|	+--+		        		|                                          |                               |                                    |        hs.invalidate();                      |
|								|                                          |  +--+                         |                                    |                                              |
|	+--+						|                                          |  |  |   BOOK2 Rs. 300         |                                    +----------------------------------------------+
|	| .|  JAVA Rs. 550      	|                                          |  +--+                         |
|	+--+						|                                          |                               |
|								|                                          |  +--+                         |
|	+--+						|                                          |  |  |   BOOK3 Rs. 250         |
|	|  |  PHP Rs. 250			|                                          |  +--+                         |
|	+--+						|                                          |                               |
|								|                                          |                               |
|								|                                          |  +-------+                    |
|	+----+						|                                          |  |Payment|                    |
|	|Next|		        		|                                          |  +-------+                    |
|	+----+						|                                          +-------------------------------+
|								|
+-------------------------------+





*/



/*

//Page1.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> PAGE 1 LANGUAGES BOOK </h1>

	<form method="GET" action="./Page2">
	
		<b> Select Books </b> <br>
		<input type="checkbox" name="Lbook" value="150"> C Rs. 150 <br> <!-- value="150" this value will go to server , C Rs. 150 this will appear on html page , type="checkbox" means we can select all options at once -->
		<input type="checkbox" name="Lbook" value="200"> C++ Rs. 200 <br>
		<input type="checkbox" name="Lbook" value="550"> JAVA Rs. 550 <br>
		<input type="checkbox" name="Lbook" value="250"> PHP Rs. 250 <br>
		
		<input type="submit" value="Next">
		
	</form>

</body>
</html>



<!-- 
			Page1.html
+-------------------------------+
|								|
|	PAGE 1 LANGUAGES BOOK		|
|								|
|	Select Books	        	|
|								|
|	+--+						|
|	|  |  C Rs. 150	        	|
|	+--+						|
|								|
|	+--+						|
|	|  |  C++ Rs. 200       	|
|	+--+						|
|								|
|	+--+						|	
|	|  |  JAVA Rs. 550			|
|	+--+						|
|								|
|	+--+						|
|	|  |  PHP Rs. 250			|
|	+--+						|
|								|
|								|
|	+----+						|
|	|Next|		        		|
|	+----+						|
|								|
+-------------------------------+
 
 -->


*/


//Page2Servlet.java 


package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Page2")
public class Page2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String values[] = request.getParameterValues("Lbook"); // earlier in login we were using "request.getParameter("uname")" because it will only take username and it is a textfield , but here we are having checkbox where name of all checkbox is same i.e. "Lbook" and from Lbook one or more values(value="150"/value="200"/value="550"/value="250") can come therefore we are using request.getParameterValues("Lbook"); and storing them into array "values[]" because many values can come                                                            
		
		//lets say values[] has [ 0:"200" , 1:"550" ]
		
		int ltotal = 0 ; //Language Total
		
		for(int i = 0 ; i < values.length ; i++) {
			
			ltotal = ltotal + Integer.parseInt(values[i]);
			
		}
		
		//Session Creation
		
		HttpSession hs = request.getSession(true);   // creating session
		
		hs.setAttribute("p1total",ltotal); // value of page 1 total is saved in ltotal
		
		// Second-Form
		
		out.println("<h1> PAGE 2 SERVLET & JSP BOOK </h1>");
		out.println("<form method='GET' action='./Page3'>");    //method='GET' written in single quote because we cannot write double quote inside double quote
		out.println("<b> Select Books </b><br>");
		out.println("<input type='checkbox' name='sjbook' value='450'> BOOK1 Rs. 450 <br>");
		out.println("<input type='checkbox' name='sjbook' value='300'> BOOK2 Rs. 300 <br>");
		out.println("<input type='checkbox' name='sjbook' value='250'> BOOK3 Rs. 250 <br>");
		
		out.println("<input type='submit' value='Payment'>");
		
		out.println("</form>");
		
		/*
		
		
		 Page2Servlet.java
+---------------------------------+
|				  				  |
|	PAGE 2 SERVLET & JSP BOOK 	  |
|				                  |
|	Select Books		          |
|				                  |
|	+--+			              |
|	|  |  BOOK1 Rs. 450	          |
|	+--+			              |
|				                  |
|	+--+			              |
|	|  |  BOOK2 Rs. 300	          |
|	+--+			              |
|				                  |
|	+--+			              |
|	|  |  BOOK3 Rs. 250           |
|	+--+			              |
|				                  |
|				                  |
|				                  |
|				                  |
|				                  |
|				                  |
|	+-------+		              |
|	|Payment|		              |
|	+-------+		              |
|				                  |
+---------------------------------+
 
		
		
		
		*/
		
		out.close();
		
	}

}



//Page3Servlet.java


package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Page3")
public class Page3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String values[] = request.getParameterValues("sjbook");                                                             
		
		
		int sjtotal = 0 ; //Language Total
		
		for(int i = 0 ; i < values.length ; i++) {
			
			sjtotal = sjtotal + Integer.parseInt(values[i]);
			
		}
		
		
		/*
		 
		 below everything is to retrive the total value of page 1(Page1.html) which we had stored in session in Page2Servlet.java
		 
		 
		 */
		
		HttpSession hs = request.getSession(false);		// Do not create new session , use the existing one which we have created earlier
		int ltotal = Integer.parseInt(hs.getAttribute("p1total").toString());  // we get this value(hs.getAttribute("p1total")) as as object(because .getAttribute() returns an object ) we need to convert it into string form therefore .toString() and we want whole thing as an integer , 750(object)-->"750"(string)-->750(Integer)                           
		
		// BILL LOGIC
		
		int bill = ltotal + sjtotal;
		
		out.println("<h2> BILL </h2>");
		out.println("Page 1 		   : Rs." + ltotal + "<br>");
		out.println("Page 2            : Rs." + sjtotal + "<br>");
		out.println("Total Bill Amount : Rs." + bill);
		
		/*
		 
		 
		          Page3Servlet.java
		 +-----------------------------------+
		 |				    				 |
		 |	BILL			     			 |
		 |				     				 |
		 |	Page 1            : Rs.750   	 |
		 |	Page 2            : Rs.300       |
		 |	Total Bill Amount : Rs.1050      |
		 |				     				 |
		 |				     		         |
		 |				                     |
		 |				                     |
		 +-----------------------------------+
		 
		 
		 
		 
		 
		 
		 */
		
		//destroy session
		hs.invalidate();
		
		out.close();
	}

}

