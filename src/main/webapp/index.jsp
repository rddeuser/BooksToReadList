<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Books to Read</title>
</head>
<body>
	<form action ="AddItemServlet" method="post">
	<p>Title: </p>
	<input type ="text" name ="title">
	<p>Author: </p>
	<input type ="text" name ="author">
	<p>Level of excitement to read (1-10): </p>
	<input type ="number" name ="excitement">
	<input type ="submit" value="Add Book">
	</form><br />
	
	<a href ="ViewAllItemsServlet">View the complete list</a>
	
	<a href="ViewAllListsServlet">View all reading lists</a>
	<a href="AddItemsForListServlet">Create a new list</a>
</body>
</html>