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
<title>Admin Page</title>
</head>
<body>
	<a href="adminList" style=float:right><u>Admin List</u></a>

 <div align="center">
 	<h3>Responses from chatbot for analysis</h3>
 	<br>
	<table cellpadding="5" border="1">
		<tr>
			<th>ID</th>
			<th>User</th>
			<th>Question</th>
			<th>Response</th>
		</tr>
		<c:forEach var="res" items="${responses}" varStatus="status">
			<tr>
			<td>${status.index+1}</td>
			<td>${res.user}</td>
			<td>${res.queString}</td>
			<td>${res.responseString}</td>
			</tr>
		</c:forEach>		
	</table>
</div>	
</body>
</html>