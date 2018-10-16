<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function pass_validation()
{
var firstpassword=document.f1.pass.value;
var secondpassword=document.f1.passed.value;

if(firstpassword==secondpassword){
return true;
}
else{
alert("password one and two must be same!");
return false;
}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if(session.getAttribute("security")==null)
	{
		response.sendRedirect("forget.jsp");
	}
	%>
	${image};
	<form action="setpassword" name="f1" onsubmit="return pass_validation()" >
		<table align="center">
		<tr>
		<td>Email:</td><td><input type="text" name="email" required/></td>
		</tr>
		<tr>
		<td>Set Password:</td><td><input type="password" name="pass" required/></td>
		</tr>
		<tr>
		<td>Confirm Password:</td><td><input type="password" name="passed" required/></td>
		</tr>
		<tr>
		<td><input type="submit" name="submit"/></td>
		</tr>
		</table>
	</form>
</body>
</html>