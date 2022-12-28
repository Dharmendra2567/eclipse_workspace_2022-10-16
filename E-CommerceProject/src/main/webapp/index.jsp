<%@page import="com.learn.mycart.helper.Helper"%>
<%@page import="com.learn.mycart.entities.Category"%>
<%@page import="com.learn.mycart.dao.CategoryDao"%>
<%@page import="com.learn.mycart.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.learn.mycart.dao.ProductDao"%>
<%@page import="com.learn.mycart.helper.SessionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/component_css_js.jsp" %>
<%@ include file="components/Navbar.jsp" %>
</head>
<body>
	<div class="row mt-3 mx-2">
		<div class="col-md-3 ">
			<div class="list-group list-sm">
 			 <a href="index.jsp?category=all" class="list-group-item list-group-item-action active" aria-current="true">All products</a>
				<%
					CategoryDao cDao = new CategoryDao();
					List<Category> category = cDao.getCategories();
					for(Category c:category){
				%>
				<a href="index.jsp?category=<%= c.getCategoryId() %>" class="list-group-item list-group-item-action" aria-current="true"><%=c.getCategoryTitle() %></a>
				<%} %>
		</div>
		</div>
		<div class="col-md-9">
			<%
			String cat = request.getParameter("category");
			ProductDao pDao = new ProductDao();
			List<Product> list=null;
			
			if(cat==null || cat.trim().equals("all")){
			 list= pDao.getAllProduct();
			}
			else{
				int cId = Integer.parseInt(cat.trim());
				list = pDao.getAllProductBycId(cId);
			}
			%>
			<div class="card-columns">
			<%
				for(Product p:list){
					%>
					
						<div class="card" style="width: 18rem;">
					  <div class="m-auto">
					  	 <img src="image/products/<%= p.getpPhoto() %>" class="card-img-top" style="max-height:270px; max-width:100%; width:auto" alt="...">
					  </div>
					  <div class="card-body">
					    <h5 class="card-title"><%= p.getpName() %></h5>
					    <p class="card-text"><%= Helper.getTenwords(p.getpDescription()) %></p>
					    
					  </div>
					  <div class=" card-footer d-flex justify-content-between">
					  	<a href="#" class="btn btn-primary">Add to Cart</a>
					     <strong class="text-danger">&#8377;<del><%=p.getpPrice() %></del></strong>
					     <strong>&#8377;<%= p.getpPrice() %></strong>
					  </div>
					</div>
					
				<%
				}
				if(list.size()==0){
					out.println("<h3>No item in category</h3>");
				
				} %>
			</div>
		</div>
	</div>
</body>
</html>