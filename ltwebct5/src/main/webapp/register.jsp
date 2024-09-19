<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="register" method="post">
<c:if test="${alert !=null}">
<h3 class="alert alertdanger">${alert}</h3>
</c:if>
		<input type="text" name="username" id="username"placeholder="Nhap username" required> 
		<input type="text" name="password" id="password" placeholder="Nhap mat khau" required>
		<input type="text" name="email" id="email" placeholder="Nhap email" required>
		<input type="text" name="fullname" id="fullname" placeholder="Nhap ho va ten" required>
		<input type="submit" value="Dang Ki">
	</form>
</body>
</html>