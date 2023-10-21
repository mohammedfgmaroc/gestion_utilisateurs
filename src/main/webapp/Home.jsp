<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ma.users.bean.User" %>
<% User user = (User) session.getAttribute("user"); %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    
</head>
<body>
    <h1>Welcome, <%= user.getNom() %> <%= user.getPrenom() %></h1>
    <div class="header">
        <a href="Profile.jsp">Your Profile</a> | <a href="LogoutServlet">Logout</a>
    </div>
    <!-- content  -->
</body>
</html>