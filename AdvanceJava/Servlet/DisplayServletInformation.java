package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/display")
public class DisplayServletInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h1> Hello Tca </h1>");                                  // Hello Tca
		 
		out.println("<br>Request Method : " + request.getMethod());			  // Request Method : GET
		out.println("<br>Request URL : " + request.getRequestURL());		  // Request URL : http://localhost:8080/ASS03-DisplayServletInformation/display
		out.println("<br>Protocol : " + request.getProtocol());               // Protocol : HTTP/1.1
		out.println("<br>Remote Address : " + request.getRemoteAddr());		  // Remote Address : 0:0:0:0:0:0:0:1
		out.println("<br>Server Name : " + request.getServerName());		  // Server Name : localhost
		out.println("<br>Port Number : " + request.getServerPort());          // Port Number : 8080
		
		ServletContext sc = getServletContext();   // this method is present in HttpServlet , that we have extended i.e. "public class DisplayServletInformation extends HttpServlet"
		out.println("<br> Server Software : " + sc.getServerInfo());          // Server Software : Apache Tomcat/11.0.4
		
		out.close();
		
		
		
	}

}


// This data that we have printed above is of Request Header















