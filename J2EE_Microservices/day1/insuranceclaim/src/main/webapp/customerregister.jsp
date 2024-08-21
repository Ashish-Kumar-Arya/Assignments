<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Customer Register Form</h1>
	<form action="customerdetails.jsp" method="post">
		<table style="with: 50%">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName"/></td>
			</tr>
			<tr>
				<td>Pocily Name</td>
				<td><input type="text" name="policyName"/></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input  type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password"/></td>
			</tr>
			<tr>
				<td>Contact</td>
				<td><input  type="text" name="contact"></td>
			</tr>
		</table>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>