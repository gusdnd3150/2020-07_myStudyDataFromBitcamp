
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>  

     <h1> 표현 언어로 여러가지 데이터 출력하기</h1>
     <h1>
     \${100}:${100} <br>
     \${"안녕하세요 }:${"안녕하세요 }<br>
     \${"10"+1}:${"10"+1 }<br>      숫자형 문자열과 실제 숫자를 더하면 문자열을 자동으로 
     \${10+1}:${10+1 }<br>                     숫자로 변환하여 더한다.
     <%-- /${null+10} : ${null+10} --%>             null과 숫자를 더할 수는 없다.
     <%-- /${"안녕"+10} : ${"안녕"+10} --%>
     <%-- /${"hello"+"world"} : ${"hello"+"world"} --%>
     </h1>
     
</body>
</html>