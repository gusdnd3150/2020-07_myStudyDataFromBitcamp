<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<style>
.img{
width:200px;
height:400px;
}
</style>

<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
</head>
<body>

         <!-- 단일 이미지는 잘나옴 -->
        <img class="img" alt=" " src="data:image/jpg;base64, ${data}" />
         
         <!-- 리스트 이미지(사용시 띄어쓰기에 주의)그냥 아래 양식을 쓸것 -->
	  <c:forEach var="data" items="${encodinglist}"  >     
         <img class="img" alt=" " src="data:image/jpg;base64, ${data}" />  
     </c:forEach> 
</body>
</html>
