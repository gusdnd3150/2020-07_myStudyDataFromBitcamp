<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <jsp:useBean id ="b"  scope ="request" class="beanTest.BoardBean" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
         아이디 : <%= b.getId() %>
         비밀번호 : <%= b.getPwd() %>
         제목 : <%= b.getTitle() %>
         내용 : <%= b.getContent() %>
         
</body>
</html>