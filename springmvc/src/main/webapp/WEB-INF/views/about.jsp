<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>about</title>
</head>
<body>
<h1>This is the about servlet page</h1>
<h1>my name is ${name}</h1>

<%String str=(String) request.getAttribute("name"); %>
<h1>
<%=str %>
</h1>
<%List<String> stu= (List<String>) request.getAttribute("student"); %>
<%for(String s:stu){%>
<h1><%=s %></h1>
<%
}
%>

</body>
</html>