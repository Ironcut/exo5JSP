<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="jsp.css" />
<title>Bienvenue</title>
</head>
<body>
	<h1>
    <% 
    String nom = (String) request.getAttribute("nom");
    String prenom = (String) request.getAttribute("prenom");
    String id = (String) request.getAttribute("id");
    out.println( "Bienvenue " + prenom + " " + nom + "<br>(identifiant n° " + id + ")");
    %>
    </h1>
</body>
</html>