<%@page import="java.util.Base64"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% User user = (User)request.getSession().getAttribute("user"); %>
	<% String name = user.getUsername(); %>
	<% String email =  request.getParameter("email"); %>
	
	
	<h3>Hello <%= name %></h3>
	<h3>Email:<%= email %></h3>
	
	<% String image = new String(Base64.getEncoder().encode(user.getUserimage())); %>
	<img alt="" src="data:image/jpeg;base64,<%= image %>"width="150" height="100">
	<br>
	
	 
	
	<button>addTask</button>
	
	
	
</body>
</html>