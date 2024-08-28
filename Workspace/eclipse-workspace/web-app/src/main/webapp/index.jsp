<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>This is home page</h1>
 <p>This is a paragraph</p>
 <%= new Date().toLocaleString() %>
 <br>
 <a href="MyServlet">Login Servlet</a>
</body>
</html>