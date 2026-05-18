package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sum")
public class SumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		
		int x = Integer.parseInt(a);
		int y = Integer.parseInt(b);
		
		/*
			 can also be written as 
		     
		     int x = Integer.parseInt(request.getParameter("a"));
			 int y = Integer.parseInt(request.getParameter("b"));
		     
		*/
		
		/*
		  
		  	Validation if values are not entered in the field
		  
		  	String a = request.getParameter("a");
			String b = request.getParameter("b");
		  
		  	if(a.length()==0 || b.length()==0){
		  	
		  		out.println("Error-Message : All input is not Received !!!");
		  	
		  	}
		  	
		  	else{
		  	
		  		int x = Integer.parseInt(a);
				int y = Integer.parseInt(b);
		  	
		  		int z = x + y ;
		  		
		  		out.println("Addition : " + z);
		  		
		  	}
		  
		  --->This Validation is done by java developer , it is kept on Java server means server is doing the validation
		  	  but servlet is not for validation it is to take data and save it to database , 
		  	  for validation javascript is there or "required" attribute can be used in HTML
		  
		  
		 */
		
		int z = x + y ;
		
		out.println("Addition : " + z);
		
		out.close();
		
	}

}










**********************************************************************************************************************************************************************************************

/*

Sum.html
--------

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<form method = "post" action="./sum">
	
		Number 1 : <input type ="number" name="a" required><br>
		Number 2 : <input type ="number" name="b" required><br>
		<input type="submit" value="Add">
	
	</form>

</body>
</html>










*/


