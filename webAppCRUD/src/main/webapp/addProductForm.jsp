<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Product</h1>
<form action="addProduct" method="POST">
<input type="text" name="name" placeholder="product name"><br>
<input type="text" name="manufacturer" placeholder="manufacturer"><br>
<input type="text" name="description" placeholder="description"><br>
<input type="number" name="price" placeholder="price"><br>
<input type="radio" name="inStock" value="true">InStock
<input type="radio" name="inStock" value="false">Not InStock<br>
<input type="submit" value="submit">
</form>

</body>
</html>