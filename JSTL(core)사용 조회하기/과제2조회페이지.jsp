<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");
%> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그인창</title>
</head>
<body>
   <form   action="과제2.jsp"  method="post">
       아이디:  <input type="text"  name="id"><br>
      <input type="submit"  value="조회">
      <input type="reset"  value="다시입력">
   </form>
</body>
</html>