<%@page import="com.learn.mycart.entities.User"%>
<%
	User user =(User) session.getAttribute("current-user");
	if(user==null){
		session.setAttribute("errormessage","your are not logged in!! login first");
		response.sendRedirect("login");
		return;
	}
	else{
		if(user.getUserType().equalsIgnoreCase("normal")){
			 session.setAttribute("errormessage","you have no access to this page");
			 response.sendRedirect("login");
			 return;
		}
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<%@ include file="components/component_css_js.jsp" %>
</head>
<body>
<%@ include file="components/Navbar.jsp" %>
	<div class="container admin">
		<div class="row mt-1">
			<div class="col-md-4 text-center">
				<div class="card shadow-lg">
					<div class="card-body mt-5">
						<img src="image/users.png" class="img-fluid rounded-circle" style="max-width:120px">
						<h2>3423</h2>
						<h1>Users</h1>
					</div>
				</div>
			</div>
			<div class="col-md-4 text-center">
			<div class="card shadow-lg">
					<div class="card-body mt-5">
						<img src="image/categories.png" class="img-fluid rounded-circle" style="max-width:120px">
						<h2>3423</h2>
						<h1>Categories</h1>
					</div>
				</div>
			</div>
			<div class="col-md-4 text-center">
			<div class="card shadow-lg">
					<div class="card-body mt-5">
						<img src="image/products.png" class="img-fluid rounded-circle" style="max-width:120px">
						<h2>3423</h2>
						<h1>Products</h1>
					</div>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-6 text-center">
			<div class="card-sm shadow-lg" data-toggle="modal" data-target="#add-category-modal"">
					<div class="card-body">
						<a href="#"><img src="image/addcategory.png" class="img-fluid rounded-circle" style="max-width:120px"></a>
						<h1>Add Categories</h1>
					</div>
				</div>
			</div>
			<div class="col-md-6 text-center">
			<div class="card-sm shadow-lg">
					<div class="card-body">
						<a href="#"><img src="image/addproduct.png" class="img-fluid rounded-circle" style="max-width:120px"></a>
						<h1>Add Products</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- modal component -->
	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-category-modal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="add-category-modal" tabindex="-1" aria-labelledby="add-category-modal" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="add-category-modal">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
	
</body>
</html>