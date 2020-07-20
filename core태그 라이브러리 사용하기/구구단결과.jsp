<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  request.setCharacterEncoding("UTF-8");
%>    
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력창</title>
</head>
<body>
 <c:set var="dan" value="${param.dan}" />  구구단jsp로부터 값을 받는다
 
 <table border="1" width="800" align="center">
  <tr align="center" bgcolor="lightgreen"> 
    <td colspan="2"> <c:out value="${dan}" />단 출력  </td>
  </tr>
                                  
<c:forEach var="i"  begin="1" end="9" step="1"  >   1~9까지 숫자를 반복 for문의 i를 생각하면됨  
  <tr align=”center”>                           ㅇ
     <td width="400"> 
       <c:out value="${dan}" /> * <c:out value="${i}" />    c:out은 출력문구를 뜻함
  	</td>
  	<td width="400">
  	   <c:out value="${i*dan }" />
  	</td>
  </tr>
</c:forEach>
</table>
</body>
</html>