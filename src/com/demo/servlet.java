package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String sq=request.getParameter("sq");
		String answer=request.getParameter("answer");
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","lavi555");
		PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?)");
		ps.setString(1, uname);
		ps.setString(2, pass);
		ps.setString(3, sq);
		ps.setString(4, answer);
		int a=ps.executeUpdate();
		System.out.println(a);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		response.sendRedirect("login.jsp");
	}

}
