<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update Product</h1>
${product }
<form action="updateProduct" method="POST">
<input type="hidden" name="id" value="${product.id }">
<input type="text" name="name" value="${product.name}"><br>
<input type="text" name="manufacturer" value="${product.manufacturer }"><br>
<input type="text" name="description" value="${product.description}"><br>
<input type="number" name="price" value="${product.price}"><br>
<input type="radio" name="inStock" ${product.inStock?"checked":"" }>InStock
<input type="radio" name="inStock" ${product.inStock?"":"checked"}>Not InStock<br>
<input type="submit" value="submit">
</form>

</body>
</html>