<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url value="/" var="URL"></c:url>  <!-- value="/" nghĩa là nếu contextpath là /ltwebct5 thì URL lúc này mang giá trị /ltwebct5/ -->
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- begin content -->

<sitemesh:write property="body"/>

<!-- end content -->
<script src="${URL}assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script>
function chooseFile(fileInput) {
    if (fileInput.files && fileInput.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            // Update the image source to the uploaded file's data URL
            $('#imagess').attr('src', e.target.result);
        }
        reader.readAsDataURL(fileInput.files[0]);
    }
}
</script>

</body>
</html>