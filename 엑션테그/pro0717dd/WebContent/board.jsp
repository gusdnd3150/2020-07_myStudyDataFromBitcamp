<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id ="b"  scope ="request" class="beanTest.BoardBean" />
    
    <%
    b.setId("dkdlel");
    b.setPwd("ddd");
    b.setTitle("제목");
    b.setContent("내용");

    %>
 
    <jsp: forward page = "boardUse.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>