/*

  what we have done basically here is we creates a login page using Login.html
  and access it on browser by http://localhost:8080/ASS05-LoginApp/Login.html

  then we created a LoginServlet , where we took the username and password and redirected it to HomeServlet if we entered valid password and username

*/

//LoginServlet

package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text.html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		if(uname.equals("sachin") && pwd.equals("tca")) {
			// out.println("<h1>Login Successfully</h1>");
		    
			// response.sendRedirect("https://www.technocompacademy.com");   // It is by default GET method
			
			// response.sendRedirect("http://localhost:8080/ASS05-LoginApp/Home"); // It is by default GET method
			
			// response.sendRedirect("./Home"); also works
			
			// The below is done because we are calling HomeServlet from LoginServlet and HomeServlet's request method is POST while "response.sendRedirect" is GET method bydefault
			RequestDispatcher rd = request.getRequestDispatcher("./Home");
			rd.forward(request, response); // LoginServlet madhe aaleli request , response , doPost mi as it is HomeServlet(/Home) la forward keli
			
		}
		else {
			//out.println("<h1>Login Unsuccessfully</h1>");
			
			//To create a PopUp
			out.println("<script>alert('Login Failed')</script>"); //alert() is a function of javascript , therefore written in script tag and in alert we wrote the msg Login Failed 
			
			//To load login page again after popup appears
			out.println("<form method=\"POST\" action=\"./Login\">\r\n"
					  + "Username : <input type=\"text\" name=\"uname\"><br>\r\n"
					  + "Password : <input type=\"password\" name=\"pwd\"><br>\r\n"
					  + "<input type=\"submit\" Value=\"Login\">\r\n"
					  + "</form>");
			
			
		}
		
		
		
		
		out.close();
		
	}

}

//HomeServlet

package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		response.sendRedirect("./Login.html");    // even if in URL we write http://localhost:8080/ASS05-LoginApp/Home we will get redirected to login page i.e. it avoids going to Home page directly from browser , you can go to Home page only after Login
		
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1> Welcome to Techno Comp Academy </h1>");
		
		out.close();
		
		
	}

}


//Login.html

/*

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="POST" action="./Login">
	
		Username : <input type="text" name="uname"><br>
		Password : <input type="password" name="pwd"><br>
		
		<input type="submit" Value="Login">
		
	</form>


</body>
</html>

*/


















