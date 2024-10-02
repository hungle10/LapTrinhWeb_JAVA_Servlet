<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<a href="${pageContext.request.contextPath }/admin/category/add">Add Category</a>
<table border="1" width="100%">
    <tr><!-- row -->
        <th>STT</th> <!-- column -->
        <th>Images</th>
        <th>Category Name</th>
         <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listcate}" var="cate" varStatus="STT">
        <tr>
            <td>${STT.index + 1}</td> <!-- data trong 1 ô -->
            <td>
            <c:if test ="${cate.images.substring(0,5) != 'https' }">
            <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
             <img height="150" width="200" src="${imgUrl}" alt="${cate.categoryname} Image" />
            </c:if>
            <c:if test ="${cate.images.substring(0,5) == 'https' }">
            <c:url value="${cate.images}" var="imgUrl"></c:url>
             <img height="150" width="200" src="${imgUrl}" alt="${cate.categoryname} Image" />
            </c:if>
            </td>
            <td>
            <c:url value="${cate.categoryname}"></c:url>
            </td>
            <td>
            <c:if test="${cate.status == 1}">
            <span>Hoạt động</span>
            </c:if>
                        <c:if test="${cate.status != 1}">
            <span>Khóa</span>
            </c:if>
            </td>
            <td>
            <a href="<c:url value='/admin/category/edit?id=${cate.categoryid }'/>">Sua</a>
            <a href="<c:url value='/admin/category/edit?id=${cate.categoryid }'/>">Xoa</a>
            </td>
        </tr>
    </c:forEach>
</table>
