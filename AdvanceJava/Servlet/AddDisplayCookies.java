/*


Cookies
-------

--> Cookies are values , stored by server at client-side(browser's file) in the form of key-value pair

--> Cookies are saved by server because further refrences to the server
    (ex:If we are having a new machine on which we have not done anything yet , we open our Gmail , enter our mail id
    for the 1st time , then we close it , and open again to send some mail , we don't have to again write our mail id,
    a pop up appears because the mail id we entered earlier is saved as a cookie)

--> Cookies are permanent value , till you don't clear it

--> we can set age to cookies i.e. how much time it should be active (Expiry Date)

--> Note : If the browser has disabled cookies then it will not get saved


           Browser                                                              Tomcat
    +--------------------+                Request                       +---------------------+
    |                    |--------------------------------------------->|                     |
    |                    |<---------------------------------------------|                     |
    |                    |           Response + Cookies                 |                     |
    |                    |                                              |  DemoServlet.java   |
    |                    |                                              |                     |
    |                    |          Request + Cookies                   |                     |
    |                    |--------------------------------------------->|                     |
    |                    |<---------------------------------------------|                     |
    |                    |          Response + Cookies                  |                     |
    +--------------------+                                              +---------------------+

          
        --> When 1st time request is send , Response comes with cookies , then after 1st request all request will 
            go with cookies , and response will also come with cookies but this cookies(after 2nd response) might
            be same as previous or may have new values in it.



          Cookies
    +--------------------+
    | KEY       VALUE    |
    |Sachin     Dhane    |
    |                    |
    |                    |
    |                    |
    |                    |
    |                    |
    |                    |
    +--------------------+



*/


//AddCookieServlet

package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Add")
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	/*	
		
		//cookie creation
		Cookie ck1 = new Cookie("Sachin" , "Dhane");
		Cookie ck2 = new Cookie("Saurabh" , "Deo");
		
		ck1.setPath("/");   // cookie should get saved in main directory of server , "/" --> root directory , root directory means , our folder is ASS06-Cookie-Demo , so here cookie should get saved ex: http://localhost:8080/ASS06-Cookie-Demo/ this is root                         
		ck2.setPath("/");
		
		//Above we created cookies , but to save them at client side it should go with response 
		response.addCookie(ck1); //adding cookie in the header of response
		response.addCookie(ck2);
		
	*/
		
		/*
		 
		       we added new cookie here , because if we have added Sachin Tendulkar(Sachin is key and Tendulkar is value)
		       then it would have get overwrited on Sachin Dhane because key are unique entities.
		 
		 */
		
		
		Cookie ck1 = new Cookie("TCA" , "Programming");
		
		ck1.setPath("/");
		
		ck1.setMaxAge(5);       // cookie is active till 5 seconds
		//ck1.setMaxAge(0);    // to delete cookie ck1
		
		response.addCookie(ck1);
		
		out.println("<h3> Cookies are Saved </h3>");
		out.close();
		
	}

}


//DislpayCookiesServlet



package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Display")
public class DislpayCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie c[] = request.getCookies(); // when we added cookies in AddCoookieServlet it went with response , now we are again requesting browser for DisplayCookiesServlet i.e. now request also has cookies , therefore to get those cookies we are using request.getCookies(); , and there might be many cookies therefore using array. 
		
		if(c==null) {
			out.println("No Cookies Saved !!!");
		}
		else {
			out.println("<h3> Client-Side Cookies : </h3>");                     
			                                                                  //                      c
			for(int i = 0 ; i < c.length ; i++) {							  //		+------------------------------+
																			  //		|							   |
				String key = c[i].getName();								  //	0   |key:Sachin	   value:Dhane     |
				String val = c[i].getValue();                                 //        |------------------------------|
																	          //	1   |key:Saurabh   value:De        |	
				out.println( key + "--->" + val + "<br>");							  //        |							   |
																			  //        +------------------------------+
				
				
				/*
				    o/p --->
				                Client-Side Cookies :
				                
								Sachin--->Dhane
								Saurabh--->Deo
								
								
								if we close the browser and again run http://localhost:8080/ASS06-Cookie-Demo/Display
								
								then o/p : No Cookies Saved !!!
								
								because Note : If you do not use setMaxAge() method on cookie object then cookies will 
								        ----   disappear after closing of the browser
								
				  
				  
				*/
				
			}                                                                 
			
		}
																				
		
		
		
		out.close();
		
	}

}

