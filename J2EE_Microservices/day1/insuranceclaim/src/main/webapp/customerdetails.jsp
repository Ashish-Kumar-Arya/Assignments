<%@page import="com.CustomerDao"%>
<%@page import="com.Customer"%>
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
	class="com.Customer" />
	
	<jsp:setProperty property="*" name="customer"/>
	
	<%
	CustomerDao customerDao=new CustomerDao();
	int status=customerDao.registerCustomer(customer);
	if(status>0) {
		out.print("You are successfully registered");
	}
	%>
</body>
</html>