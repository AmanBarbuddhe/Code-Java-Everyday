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


/*


--> After we write the http://localhost:8080/ASS01/hello(URL) Request is sent to Server



                 client                                                                                                             Server
+------------------------------------------+                                                               +---------------------------------------------------+
|                                          |                                                               |                                                   |
|   http://localhost:8080/ASS01/hello	   |                                                               |                                                   |
+------------------------------------------+                                                               +---------------------------------------------------+
|										   |	                                                           |                                                   |
|                                          |           Header                            Body              |                                                   |
|                                          |         +-----------------------------------------------+     |     											   |
|                                          |		 |Sender IP address   URL  |      Empty          |     |												   |
|                                          |         |Receiver IP address GET  |					 |     |         HelloServlet.class                        |
|                                          |         +-----------------------------------------------+     |                  |                                |
|                                          |															   |                  |                                |
|                                          |															   |                  |                                |
|                                          |-------------------------------------------------------------->|    +---------------------------+                  |
|                                          |<------------------------------------------------------------- |	|							|				   |
|                                          |															   |    |                           |                  |
|                                          |           Header           Body                               |    |                           |                  |
|                                          |         +-------------------------------------------------+   |    |                           |                  |
|Hello World , This is my First Servlet    |		 |header same 	|<h1 style='color:red;'>Hello World|   |  request        	          response             |
|(this is printed on page(browser)         |         |as time of    |,This is my First Servlet</h1>    |   |                      <h1 style='color:red;'>Hello |
| only after response is sent)             |         |response      |                                  |   |                   World , This is my First Servlet|
|                                          |         |              |                                  |   |                          </h1>                    |
|                                          |         +-------------------------------------------------+   |                                                   |
|                                          |                                                               |                                                   |
+------------------------------------------+                                                               +---------------------------------------------------+




--> Server wakes up Servlet-Engine , Servlet-engine sees what is the URL pattern , here the URL pattern is /hello
    , /hello is Mapped to class HelloServlet , from URL servlet engines gets idea , which servlet it has to load.

--> Now which method HelloServlet class will run? , Servlet-engine sees to Request packet and sees request method is 
    of which type , here it is "GET" method , therefore the "doGet" method will get called.

--> protected void doGet(HttpServletRequest request, HttpServletResponse response)

--> HelloServlet gets two object request and response

FLOW: 1) you entered URL and request is send to server , 2) we strike the servlet-engine , 3) servlet-engine
identifies the URL pattern and loads the servlet class(HelloServlet.class) and from the "GET" method , identifies 
which method is called , 4)everything in request body is copied in request object.

response.setContentType("text/html"); --> we decided type of response(text,image,etc...)

PrintWriter out = response.getWriter(); --> we made object to write on response

out.println("<h1 style='color:red;'>Hello World , This is my First Servlet</h1>"); --> using this we write : Hello World , This is my First Servlet in the response

out.close() --> we have stopped writing , and we are done with running our servlet

5)as soon as our running of servlet is done , servlet-engine understands that it has to now prepare the response
content in response object is copied in response packet

<h1 style='color:red;'>Hello World , This is my First Servlet</h1> --> the html and css part is executed by the browser
i.e. html , css , javascript are executed at client side 


----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


ASS01-->src-->webapp-->WEB-INF-->web.xml

Note : Now we dont need xml files because now we have annotations where we can give annotations
--> @WebServlet({ "/HelloServlet", "/hello" })   ,   @WebServlet --> annotation

Earlier when annotations were not there
---------------------------------------

--> everything about our project is in the web.xml , now that is in annotation

web.xml
--------

web.xml is deployment descriptor , if my application is running on server that means it has been deployed ,
then that deployed application is described in web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="https://jakarta.ee/xml/ns/jakartaee" xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd" id="WebApp_ID" version="5.0">
  <display-name>ASS01</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.xhtml</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.jsp</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.xhtml</welcome-file>
  </welcome-file-list>
  
  
  <servlet>                                                                                                                                                                                                                                                                              |
  	<servlet-name> Sachin </servlet-name>            //servlet-name tells by which name our servlet should be identified																																							     |
  	<servlet-class> com.tca.HelloServlet </servlet-class>         // Sachin navachi class file kuthay , so tya class cha nav i.e. here it is HelloServlet , com.tca --> package name in which HelloServlet is present , com.tca.HelloServlet is called fully qualified name              |
  </servlet>																																																																		     |
  																																																																						 |	
  <servlet-mapping>                                          |																																																							 |	
  	<servlet-name> Sachin </servlet-name> 					 |																																																							 |								
  	<url-pattern> /HelloServlet </url-pattern>               |																																																							 |	---> This block of code is not used
  </servlet-mapping>                                         |																																																							 |       now-a-days instead of this 
                                                             |----> this is for , on which url should this servlet should run																																							 |		 annotations are used.
  <servlet-mapping>                                          |		(kont url aala ki he sarvlet run karaycha?)																																											 |			
  	<servlet-name> Sachin </servlet-name>                    |																																																							 |
  	<url-pattern> /hello </url-pattern>                      | 																																																					         |												
  </servlet-mapping>                                         |																																																							 |	
  
  
  
  
</web-app>


servlet-api.jar is used to run servlet
jsp-api.jar is used to run jsp
jasper.jar is used to run spring boot


*/












