<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	body{
	background-image: url("resources/images/admin.png");
	background-size:cover ;
	}
</style>
<title>Admin List</title>
</head>
<body>
<div align="center">
	<table cellpadding="5" border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
			</tr>
			<c:forEach var="ad" items="${admins}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${ad.name}</td>
					<td>${ad.email}</td>
					<td>${ad.password}</td>
				</tr>
			</c:forEach>
		</table>
</div>
</body>
</html>