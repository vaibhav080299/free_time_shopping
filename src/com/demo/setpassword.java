package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class setpassword
 */
@WebServlet("/setpassword")
public class setpassword extends HttpServlet {
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String conf=request.getParameter("passed");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","lavi555");
			PreparedStatement ps=con.prepareStatement("update register set password='"+pass+"' where uname='"+email+"'");
			int status=ps.executeUpdate();
			if(status==1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
				PrintWriter out=response.getWriter();
				out.println("Your Password is Updated");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("setpass.jsp");
				rd.include(request, response);
				PrintWriter out=response.getWriter();
				out.println("Wrong Email Address");

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	

}
