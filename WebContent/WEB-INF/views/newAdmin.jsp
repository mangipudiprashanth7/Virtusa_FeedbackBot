<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration Page</title>
</head>
<body>
	<div align ="center">
		<h2>Admin User Registration</h2>
		<form:form action="save" method="post" modelAttribute="admin">
		<table cellpadding="5">
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>	
				<td>Email:</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>	
				<td>Password:</td>
				<td><form:input path="password" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="SignUp" />
			</tr>	
		</table>		
		</form:form>
	</div>
</body>
</html>