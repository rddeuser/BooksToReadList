<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Item</title>
</head>
<body>
<form action="EditItemServlet" method="post">
<input type="hidden" name ="title" value="${itemToEdit.title}">
Title: <input type="text" name="newTitle" value="${itemToEdit.title}">
Author: <input type="text" name="author" value="${itemToEdit.author}">
Excitement Rating: <input type="number" name="excitement" value="${itemToEdit.excitementRating}">
<input type="submit" value="Save Edited Item">
</form>
</body>
</html>