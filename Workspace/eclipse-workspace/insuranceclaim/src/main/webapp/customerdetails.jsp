<%@page import="com.addData.CustomerDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="customer"
	class="com.addData.Customer" />
	
	<jsp:setProperty property="*" name="customer"/>
	
</body>
</html>