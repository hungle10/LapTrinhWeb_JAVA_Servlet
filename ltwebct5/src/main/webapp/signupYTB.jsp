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
if("done".equals(msg))
{
	%>
	<h2>Dang ki thanh cong</h2>
	<% } %>
	<% 
if("invalid".equals(msg))
{
	%>
	<h2>Dang ki that bai</h2>
	<% } %>
	<form action="signupActionYTB.jsp" method="post">
		<input type="text" name="name" id="name" placeholder="Nhap ho va ten"required> 
		<input type="text" name="email" id="email"placeholder="Nhap email" required> 
		<input type="text" name="password" id="password" placeholder="Nhap mat khau" required>
		<input type="number" name="phone" id="phone" placeholder="Nhap so dien thoai" required> 
		<input type="submit" value="Dang ky">
	</form>
	<br />
	<h2>
		<a href="LoginYTB.jsp">Dang nhap</a>
	</h2>
	<br />
	<h2>
		<a href="ForgetPassword.jsp">Quen mat khau</a>
	</h2>
</body>
</html>