<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ma.users.bean.User" %>
<% User user = (User) session.getAttribute("user"); %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    
</head>
<body>
    <h1>Your Profile, <%= user.getNom() %> <%= user.getPrenom() %></h1>
    <div class="header">
        <a href="Home.jsp">Back to Home</a> | <a href="LogoutServlet">Logout</a>
    </div>

    <h2>User Information</h2>
    <form action="ProfileUpdateServlet" method="post">
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" value="<%= user.getNom() %>">
        <br>
        <label for="prenom">Prenom:</label>
        <input type="text" id="prenom" name="prenom" value="<%= user.getPrenom() %>">
        <br>
        <label for="password">Mot de passe actuel :</label>
        <input type="text" id="password" name="currentPassword" value="<%= user.getMotDePasse() %>" readonly>
        <br>
        <label for="newPassword">Nouveau mot de passe :</label>
		<input type="password" id="password" name="newPassword">
		<br>
        <label for="email">Adresse e-mail :</label>
        <input type="email" id="email" name="email" value="<%= user.getEmail() %>">
        <br>
        
        <input type="submit" value="Update Profile">
    </form>
</body>
</html>