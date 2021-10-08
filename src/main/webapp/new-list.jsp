<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New List</title>
</head>
<body>
	<form action = "CreateNewListServlet" method="post">
	List Name: <input type="text" name="listName"><br />
	Reader Name: <input type="text" name="readerName"><br />
	
	Available Items:<br />
	<select name="allItemsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allItems}" var="currentItem">
	<option value = "${currentItem.title}">${currentItem.title} | ${currentItem.author} | ${currentItem.excitementRating}</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Create List and Add Items">
	</form>
	
	<a href="index.html">Go add new items instead</a>

</body>
</html>