<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/admin/category/edit?id=${cate.categoryid}" method="post" enctype="multipart/form-data">
<label for="categoryname">Category Name</label><br>
<input type="text" id="categoryname" name="categoryname" value = ${cate.categoryname }><br>
<label for="images">Images:</label><br>
<input type="file" id="images" name="file" onchange="chooseFile(this)" value = ${cate.images }><br>
 <c:if test ="${cate.images.substring(0,5) != 'https' }">
 <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
</c:if>

 <c:if test ="${cate.images.substring(0,5) == 'https' }">
 <c:url value="${cate.images}" var="imgUrl"></c:url>
 </c:if>
 
 <img id="imagess"  src="${imgUrl}" width="80" height="70" /><br>
<label for="status">Status</label><br>
<input type="text" id="status" name="status"><br>
<br><input type="submit" value="Submit">
</form>
</body>
</html>