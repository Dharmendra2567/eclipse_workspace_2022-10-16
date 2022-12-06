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
<h1>creating session provider</h1>
<% out.println(SessionProvider.getFactory()); %>


</body>
</html>