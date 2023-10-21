<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    
</head>
<body>
    <h1>Connexion</h1>
    
    <form action="LoginServlet" method="post">
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="username" required>
        <br>
        
        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" required>
        <br>
        
        <input type="submit" value="Se connecter">
    </form>
    
    <div class="center-text">
        <p>Pas encore inscrit ? <a href="Inscription.jsp">S'inscrire</a></p>
    </div>
    
</body>
</html>