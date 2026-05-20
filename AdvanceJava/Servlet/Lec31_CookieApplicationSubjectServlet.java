/*

			Subject.html                                                                 SubjectServlet.java
	+---------------------------+                      sb                           +----------------------------+
    |							|         +-------------------------------+         |                            |
    |	Select Subject :        |         |Maths/Physics/Chemistry/Biology|         |                            |
    |							|         +-------------------------------+         |                            |
    |		 Mathematics        |-------------------------------------------------->|                            | 
 	|		 Physics            |                                                   |                            |
    |        Chemistry          |<--------------------------------------------------|                            |
    |        Biology            |													|                            |
    |				            |			Response + Cookies						|                            |
    |  +-----+					|													|							 |
    |  |Send |					|													+----------------------------+
    |  +-----+					|
    |							|
    |  							|
    +---------------------------+



			Cookies
	+-------------------------+
    |Key    | Value(sub)      |
    +-------------------------+
    |ID1    | maths           |
    |ID2	| maths			  |
    |ID3	| maths			  |
    |ID4	| phy			  |
      .				.
      .				.
      .				.
      .				.
      .				.
      .				.
      .				.
      .				.
      .				.
      
      
      
      
*/


package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Sub")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sub = request.getParameter("sb");
		
		out.println("You have Selected "+ sub + "<br>");
		
		//to check no. of cookies
		Cookie c[] =request.getCookies();
		int count;
		
		if(c==null) {
			count=1;
		}
		else {
			count = c.length + 1;
		}
		
		//jevdhya vela subject select kelay tevdhya vela toh subject store zala pahije
		String key = "ID"+count;
		
		Cookie ck = new Cookie(key,sub);
		ck.setPath("/");
		response.addCookie(ck);
		
		if(c!=null) {
			out.println("Cookies Information <br>");
			
			for(int i = 0; i<c.length; i++) {
				
				String k = c[i].getName();
				String v = c[i].getValue();
				
				out.println("Key : " + k + " Value : " + v +"<br>");
				
			}
		}
		
		out.close();
		
		/*
		 o/p--> 
				You have Selected chem
				Cookies Information
				Key : ID1 Value : maths
				Key : ID2 Value : maths
				Key : ID3 Value : maths
				Key : ID4 Value : phy
				
				we do not see current send cookies because it is just sent in response
		*/
		
	}

}

