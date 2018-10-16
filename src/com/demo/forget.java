package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class forget
 */
@WebServlet("/forget")
public class forget extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status=false;
		String sq=request.getParameter("sq");
		String ans=request.getParameter("answer");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","lavi555");
			PreparedStatement ps=con.prepareStatement("select * from register where sq=? and sa=?");
			ps.setString(1, sq);
			ps.setString(2, ans);
			ResultSet rs=ps.executeQuery();
			 status=rs.next();
			 System.out.println("hey");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(status==true)
		{		
			
			HttpSession session=request.getSession();
			session.setAttribute("security", sq);
			RequestDispatcher rd=request.getRequestDispatcher("setpass.jsp");
			rd.forward(request, response);

		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("forget.jsp");
			rd.include(request, response);
			PrintWriter out=response.getWriter();
			out.println("Wrong Security and Answer");
			
		}
	}

}
