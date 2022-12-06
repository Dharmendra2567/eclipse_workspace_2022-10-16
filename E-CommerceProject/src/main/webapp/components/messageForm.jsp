
<% 
	String message= (String) session.getAttribute("message");
	if(message!= null){
		%>
		<div class="alert alert-success alert-dismissible fade show" role="alert">
  <strong><%= message %></strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button><br>
  <a href="index.jsp" class="btn btn-sm btn-primary">Go Back To Dashboard</a>
  
</div>
		<%
		session.removeAttribute("message");
	}
%>