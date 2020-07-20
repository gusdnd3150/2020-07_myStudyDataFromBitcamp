
 책 550페이지 


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
    <%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    
    
    <%
    request.setCharacterEncoding("utf-8");
    %>
    
    <c:set var ="id" value ="hong" scope ="page" />
    <c:set var ="pwd" value ="1234" scope ="page" />
    <c:set var ="name" value ="${'홍길동' }" scope ="page" />
    <c:set var ="age" value ="${22 }" scope ="page" />
    <c:set var ="height" value ="${177 }" scope ="page" />
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력창</title>
</head>
<body>

    <table border="1" align ="center"></table>
    
    <tr align ="center" bgcolor ="#99ccff">
    <td width ="20%"> 아이디  </td>
    <td width ="20%"> 비밀번호  </td>
    <td width ="20%"> 이름  </td>
    <td width ="20%"> 나이  </td>
    <td width ="20%"> 키  </td>
    </tr>
    
    <tr>
    <td>${id}</td>
    <td>${pwd}</td>
    <td>${name}</td>
    <td>${age}</td>
    <td>${height}</td>
    </tr>
    </table>

</body>
</html>
