<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body{
    margin: 0px;
    padding: 0;
    font-family:sans-serif;
    background-image: url("resources/images/background.png");
    background-size:cover;
  }
  .container{
    width: 80%;
    overflow:hidden;
    margin: auto;
  }
  footer h4{
  color:white;
  }
  a{
      text-decoration: none;
  }
  
  header{
    background-color:#00f0d0;
    color: white;
  }
  
  header h1{
    float: left;
    font-family: sans-serif;
  }
  .right{
    float: right;
  }
  .right table{
    margin: 10px 0px;
  }
  
  .right td{
      padding-left: 8px;
  }
  .right table td a{
    color: white;
    text-decoration: none;
  }
  .right table td a button{
    background-color:#03d3fc;
    color: white;
    padding: 3px 8px;
    text-decoration: none;
    border: 1px solid #fff;
     margin-left: 8px; 
  }
  
  section{
    background-color: #E9EBEE;
      background-size: cover;
  }
  section .connect{
    font-weight: bold;
    word-spacing: 0.2em;
    float: left;
  }
  section .create{
    float: right;
    width: 40%;
  }
  .create h1{
    font-size: 35px;
  }
  .create input{
    height: 30px;
    border-radius: 5px;
    border: transparent;
    padding: 3px;
  }
  .create .set{
    width: 80%;
  }
  .create .bg{
    height: auto;
  }
  .create button{
    padding: 8px 40px;
    background-color: #5D9149;
    color: white;
      border: none;
      border-radius: 7px;
  }
  
  label{
      display: block;
      padding: 0.7rem 0;
      font-weight: bold;
      color: gray;
  }
  .chat-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  right: 28px;
  width: 280px;
  
 footer{
 	position:fixed;
	bottom:0;
    width:100%;
    padding:7px 7px;
    padding-right:7px;
    margin-bottom:5px;
    border-radius:20px;
    border:0.5px solid #9e9e9e50;
    box-sizing:border-box ;
    background-color:#ffffff;
 }
 footer h4{
 	color: white;
 }
}

</style>
<title>Bank Chatbot Home</title>
</head>
<body>
<!--   HEADER  -->
    <header>
        <div class="container">
    <!--    TITLE  -->
            <h1>Bank Feedback Bot</h1>
            <div class="right">
 	<!--    LOGIN TAB  -->
 			<form:form action="validate" method="post" modelAttribute="authenticate">
                <table>
                    <tr>
                        <td>Email</td>
                        <td>Password</td>
                    </tr>
                    <tr>
                        <td><form:input type="text" path="emailString" /></td>
                        <td><form:input path="passwordString" type="password"/> </td>
                        <td><a href="adminPage"><button>Login</button></a></td>
                    </tr>
                    <tr>
                    	<td></td>
                        <td><a href="new">New Admin User? </a></td>
                    </tr>
                </table>
             </form:form>   
        <!--    END OF LOGIN TAB  -->
            </div>
        </div>
    </header>
  <!--    END OF HEADER  -->
 <!--  <img alt="bank" src="resources/images/background.png"> -->
  <pre>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  </pre>
  <a href="Chat"><button class="chat-button">Chat</button></a>
	<footer>
		<h4>Created by Mangipudi Prashanth Sarma</h4>
	</footer>
</body>
</html>