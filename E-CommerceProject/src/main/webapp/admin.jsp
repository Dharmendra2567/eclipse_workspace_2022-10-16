<%@page import="com.learn.mycart.entities.Category"%>
<%@page import="com.learn.mycart.dao.CategoryDao"%>
<%@page import="java.util.List"%>
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
<%@ include file="components/messageForm.jsp" %>
	<div class="container admin">
		<div class="row mt-1">
			<div class="col-md-4 text-center">
				<div class="card-sm shadow-lg ">
					<div class="card-body">
						<img src="image/users.png" class="img-fluid rounded-circle" style="max-width:120px">
						<h5>3423</h5>
						<h3>Users</h3>
					</div>
				</div>
			</div>
			<div class="col-md-4 text-center">
			<div class="card-sm shadow-lg">
					<div class="card-body ">
						<img src="image/categories.png" class="img-fluid rounded-circle" style="max-width:120px">
						<h5>3423</h5>
						<h3>Categories</h3>
					</div>
				</div>
			</div>
			<div class="col-md-4 text-center">
			<div class="card-sm shadow-lg">
					<div class="card-body">
						<img src="image/products.png" class="img-fluid rounded-circle" style="max-width:120px">
						<h5>3423</h5>
						<h3>Products</h3>
					</div>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-md-6 text-center">
			<div class="card-sm shadow-lg" data-toggle="modal" data-target="#add-category-modal">
					<div class="card-body">
						<img src="image/addcategory.png" class="img-fluid rounded-circle" style="max-width:120px">
						<h3>Add Categories</h3>
					</div>
				</div>
			</div>
			<div class="col-md-6 text-center">
			<div class="card-sm shadow-lg" data-toggle="modal" data-target="#add-product-modal">
					<div class="card-body">
						<img src="image/addproduct.png" class="img-fluid rounded-circle" style="max-width:120px">
						<h3>Add Products</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- modal component -->
	<!-- Button trigger modal -->
<div class="modal fade" id="add-category-modal" tabindex="-1" aria-labelledby="add-category-modal" aria-hidden="true">
  <div class="modal-dialog modal-md">
    <div class="modal-content">
      <div class="modal-header custom-bg text-white">
        <h5 class="modal-title" id="add-category-modal">Fill Category Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <form action="ProductOperationServlet" method="POST">
       <input type="hidden" value="addCategory" name="operation">
        <div class="form-group">
        <label>Category Title</label>
         <input type="text" class="form-control" name="category_title" placeholder="add category title">
        </div>
        <div class="form-group">
        <label>Category Description</label>
         <textarea style="height:100px"  class="form-control" name="category_description" placeholder="add category description"></textarea>
        </div>
         <div class="modal-footer m-auto">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
       </form>
      </div>
     
    </div>
  </div>
</div>

<!-- modal component -->
	<!-- Button trigger modal -->
<div class="modal fade" id="add-product-modal" tabindex="-1" aria-labelledby="add-product-modal" aria-hidden="true">
  <div class="modal-dialog modal-md">
    <div class="modal-content">
      <div class="modal-header custom-bg text-white">
        <h5 class="modal-title" id="add-product-modal">Add Product Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <form action="ProductOperationServlet" method="POST" enctype="multipart/form-data">
       <input type="hidden" value="addProduct" name="operation">
        <div class="form-group">
        <label>Category</label>
        <%
        CategoryDao cDao = new CategoryDao();
         List<Category> list = cDao.getCategories();
        %>
         <select name="categoryId" class="form-control">
         <%
          for(Category c:list){
         %>
          <option value="<%= c.getCategoryId() %>"><%= c.getCategoryTitle() %></option>
          <%} %>
         </select>
        </div>
        <div class="form-group">
        <label>Product Name</label>
         <input type="text" class="form-control" name="product_name" placeholder="add product name">
        </div>
        <div class="form-group">
        <label>Product Price</label>
         <input type="number" class="form-control" name="product_price" placeholder="add product price">
        </div>
        <div class="form-group">
        <label>Product Discount</label>
         <input type="number" class="form-control" name="product_discount" placeholder="add product discount">
        </div>
        <div class="form-group">
        <label>Product Quantity</label>
         <input type="number" class="form-control" name="product_quantity" placeholder="add product quantity">
        </div>
        <div class="form-group">
        <label>Product Pic</label>
         <input type="file" class="form-control" name="product_pic" placeholder="choose file">
        </div>
        <div class="form-group">
        <label>Product Description</label>
         <textarea style="height:100px"  class="form-control" name="product_description" placeholder="add product description"></textarea>
        </div>
          <div class="modal-footer m-auto">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
       </form>
      </div>
     
    </div>
  </div>
</div>
</body>
</html>