<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

     안녕하세요 쇼핑몰 중심 jsp입니다.
         <br>
    <jsp:include page ="duke_image.jsp" flush ="true" >
    <jsp:param name ="name" value ="듀크2" />
    <jsp:param name ="imgName" value ="duke2.png" />
    </jsp:include>
    <br>
    안녕하세요 쇼핑몰 중심 jsp끝부분입니다.

</body>
</html>