<%@page import="com.learn.mycart.entities.User"%>
<%
  User user1 =(User) session.getAttribute("current-user");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row custom-bg">
			<div class="col-12 col-md-6 col-lg-3 text-center">
				<h3 class="fw-bold fs-2" >
				<img src="image/cart.png" alt=""  width="50" height="57" class="rounded-circle">MyCart</h3>
			</div>
			<div class="col-12 col-md-9 col-lg-6">
				<form class="d-flex pt-1">
			      <input class="form-control mr-sm-2 mr-lg-2" type="search" placeholder="Search" aria-label="Search">
			      <button class="btn btn-outline-light text-dark mr-sm-0 mt-lg-0" type="submit">Search</button>
    			</form>
			</div>
		<%
			if(user1==null){
		%>
		<div class="col-12 col-md-6 col-lg-3 text-center">
			<a class="btn btn-warning text-dark" href="loginForm.jsp">Login</a>
			<a class="btn btn-danger text-dark" href="registerForm.jsp">Register</a>
		</div>
		<% }
		else {
		%>
		<div class="col-12 col-md-6 col-lg-3 text-center">
			<a class="btn btn-warning text-dark" href="#">Hi, <%= user1.getUserName() %></a>
			<a class="btn btn-danger text-dark" href="logout">Logout</a>
		</div>
		<%} %>
		<nav class="navbar navbar-expand-lg navbar-light ml-5 mt-0">
		  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
 			 </button>
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">Link</a>
		      </li>
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
		          Categories
		        </a>
		        <div class="dropdown-menu">
		          <a class="dropdown-item" href="#">Action</a>
		          <a class="dropdown-item" href="#">Another action</a>
		          <div class="dropdown-divider"></div>
		          <a class="dropdown-item" href="#">Something else here</a>
		        </div>
		      </li>
		    </ul>
		  </div>
		</nav>
	</div>
	</div>
</body>
</html>