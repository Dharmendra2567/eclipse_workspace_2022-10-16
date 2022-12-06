<%@page import="webAppCRUD.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<style type="text/css">
	table,td,th,tr,tbody{
	border-collapse: collapse;
	}
	table {
	width:70%;
	margin:auto;
	}
	th,td{
	padding:5px;
	text-align:center;
	font-size:24px;
	}
	tbody tr:nth-child(even) {
	background-color:gray;}
	thead tr {
	background-color:green;
	}
	th:first-child{
	border-radius:20px 0 0 0;}
	th:last-child{
	border-radius:0 20px 0 0;}
	</style>
</head>
<body>
<h1>Product List</h1>
<a href="addProduct"><button>Add New Product</button></a>
<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Manufacturer</th>
			<th>Description</th>
			<th>Price</th>
			<th>InStock</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<%
	ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
	for(Product p:products) {
		out.print(
				"<tr><td>"+p.getId()+
				"</td><td>"+p.getName()+
				"</td><td>"+p.getManufacturer()+
				"</td><td>"+p.getDescription()+
				"</td><td>"+p.getPrice()+
				"</td><td>"+p.isInStock()+
				"</td><td>"+"<a href='updateProduct?id="+p.getId()+"'><button>Edit</button></a>"+
						"<a href='deleteProduct?id="+p.getId()+"'><button>Delete</button></a>"+
				"</td></tr>"
				);
	}
	%>
	</tbody>
</table>

</body>
</html>