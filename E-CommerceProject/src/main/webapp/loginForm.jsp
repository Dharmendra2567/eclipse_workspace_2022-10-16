<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>

<%@ include file="components/component_css_js.jsp" %>
</head>
<body>
<%@ include file="components/Navbar.jsp" %>
	<div class="col-md-6 m-auto">
		<div class="card shadow mt-2 mb-3">
			<div class="card-body ml-5 mr-5 px-4 py-4 g-3">
			<%@ include file="components/messageForm.jsp" %>
			<%@ include file="components/errorMessage.jsp" %>
				<form action="login" method="POST">
        <div class="text-center">
      <img class="mb-4 rounded-circle" src="image/login.png" alt="jj" width="60" height="67">
      <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
    </div>
  
      <div class="form-floating mb-2">
       <label for="email">Email address</label>
        <input type="email" class="form-control" name="email" placeholder="name@example.com">
       
      </div>
      <div class="form-floating">
      <label for="password">Password</label>
        <input type="password" class="form-control" name="password" placeholder="Password">
        
      </div>
  
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <div class="d-flex justify-content-evenly">
      	<button class="w-50 btn btn-md btn-primary" type="submit">Sign in</button>
      <button class="w-50 ml-3 btn btn-md btn-warning" type="reset">Reset</button>
      </div>
      Do Not Have Account?<a href="registerForm.jsp">register</a>
    </form>
			</div>
		</div>
			
		</div>
</body>
</html>