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

			<div class="col-md-6 m-auto">
				<div class="card shadow-lg mt-2 mb-3">
				<%@ include file="components/messageForm.jsp" %>
		<div class="card-body mr-5 ml-5 ">
		
		<form action="register" method="POST">
        <div class="text-center">
      <img class="mb-4 rounded-circle" src="image/login.png" alt="" wnameth="60" height="67">
      <h1 class="h3 mb-3 fw-normal">Register</h1>
    </div>
  	  
  	  <div class="form-floating mb-2">
       <label for="userName">UserName</label>
        <input type="text" class="form-control" name="userName" placeholder="Enter username">
      </div>
  	  <div class="form-floating mb-2">
       <label for="userAddress">Address</label>
        <input type="text" class="form-control" name="userAddress" placeholder="Enter your address">
      </div>
      <div class="form-floating mb-2">
       <label for="emailAddress">Email address</label>
        <input type="email" class="form-control" name="userEmail" placeholder="name@example.com">
      </div>
      <div class="form-floating">
      <label for="userPassword">Password</label>
        <input type="password" class="form-control" name="userPassword" placeholder="Password">
      </div>
      	<div class="form-floating mb-2">
       <label for="userPhone">Phone</label>
        <input type="number" class="form-control" name="userPhone" placeholder="Enter your phone number">
      </div>
      <div class="form-floating mb-2">
       <label for="userPic">Upload Pic</label>
        <input type="file" class="form-control" value="default.jpg" name="userPic" placeholder="choose file">
      </div>
  
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <div class="d-flex">
      	<button class="w-50 btn btn-md btn-primary" type="submit">Submit</button>
      <button class="w-50 ml-3 btn btn-md btn-warning" type="reset">Reset</button>
      </div>
      Already Registered?<a href="loginForm.jsp">sign in here</a>
    </form>
</div>
		</div>
	</div>
</body>
</html>