<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Books to Read</title>
<script type="text/javascript">
	function checkInput() {
		
		if (document.addItem.title.value == "") {
			alert("No title given, please add a title.")
			document.addItem.title.focus();
			return false;
		}
		
		if (document.addItem.author.value == "") {
			alert("No author given, please add an author.")
			document.addItem.title.focus();
			return false;
		}
		
		if (document.addItem.excitement.value == "" || isNaN(document.addItem.excitement.value)
				|| document.addItem.excitement.value < 1 || document.addItem.excitement.value > 10) {
			alert("Invalid rating, please add a rating between 1-10.")
			document.addItem.title.focus();
			return false;
		}
		return (true)
	}
</script>
</head>
<body>
	<form action ="AddItemServlet" name="addItem" method="post" onsubmit="return(checkInput())">
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