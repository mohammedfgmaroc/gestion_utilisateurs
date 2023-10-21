<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    
</head>
<body>
    <h1>Inscription</h1>
    
    <form action="RegistrationServlet" method="post">
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required>
        <br>
        <label for="prenom">Prenom :</label>
        <input type="text" id="prenom" name="prenom" required>
        <br>
        
        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" required>
        <br>
        
        <label for="email">Adresse e-mail :</label>
        <input type="email" id="email" name="email" required>
        <br>
        
        <input type="submit" value="S'inscrire">
    </form>
</body>
</html>