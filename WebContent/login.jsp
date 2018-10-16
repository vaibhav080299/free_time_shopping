<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	session.setAttribute("image","/img/2.jpg");
	%>
	<h1 align="center">Login</h1>
	<form action="loginAction">
		<table align="center">
			<tr>
				<td>Username/Email:</td>
				<td><input type="text" name="email" required/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required/></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit"/></td>
				<td><a href="forget.jsp"/>Forget Password</a></td>
				<td><a href="index.html"/>Sign up</a></td>
				<td><a href="delete.jsp"/>Do You Want you Delete your Account</a></td>
			</tr>
			
		</table>
	</form>
</body>
</html>