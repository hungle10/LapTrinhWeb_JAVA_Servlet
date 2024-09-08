<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String msg = request.getParameter("msg");
if("valid".equals(msg))
{
	%>
	<h2>Dang nhap thanh cong</h2>
	<% } %>
	<% 
if("invalid".equals(msg))
{
	%>
	<h2>Dang nhap that bai</h2>
	<% } %>
<form action="LoginActionYTB.jsp" method="post">
		<input type="text" name="email" id="email"placeholder="Nhap email" required> 
		<input type="text" name="password" id="password" placeholder="Nhap mat khau" required>
		<input type="submit" value="Dang Nhap">
	</form>
</body>
</html>