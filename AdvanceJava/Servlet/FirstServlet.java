package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet({ "/HelloServlet", "/hello" }) // Mapping , by writing this after --> http://localhost:8080/ASS01 we get our result , means Hello World , This is my First Servlet gets displayed after http://localhost:8080/ASS01/HelloServlet or http://localhost:8080/ASS01/hello                                                
public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  // here we are sending response as text , if sending photo then image/jpg
		
		PrintWriter out = response.getWriter(); // this writes the response
		
		out.println("<h1 style='color:red;'>Hello World , This is my First Servlet</h1>");
		//not System.out.println , because we don't want output on system i.e. on our terminal , we want it on browser
		
		out.close();
	}

}
