<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
   String cookieName = "id";
   Cookie cookie = new Cookie(cookieName, "hongkd");      //쿠키를 생성하는 과정
   cookie.setMaxAge(60*2);                            쿠키 유효시간 설정
   cookie.setValue("kimkd");                             쿠키값 value값 변경
   response.addCookie(cookie);
%><P>

<%=cookieName%> 쿠키가생성 되었습니다.<br>
<input type="button" value="쿠키의 내용확인" onclick="javascript:window.location='useCookie.jsp'">
</P>
</body>
</html>





-- useCookie.jsp


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>


<%
 Cookie[] cookies = request.getCookies();          //일반적으로 사용했던 쿠키값을 구하는 패턴이었다
 if(cookies!=null){                                 // 쿠키는 생성후 배열안에 저장되기때문에 for룹을 돌림
     for(int i=0; i<cookies.length;++i){
         if(cookies[i].getName().equals("id")){ // ID란 key로 저장된 Cookie value를 찾는다.
%>
             쿠키의 이름은 "<%=cookies[i].getName()%>" 이고         // 쿠키값을 이렇게도 뽑을 수 있지만 아래 EL코드를 사용하여 이 긴 로직을 한줄로 요약가능하다
             쿠키의 값 "<%=cookies[i].getValue()%>" 입니다.
<%
                        }
                    }
                }
%>
<br>
id에 대한 쿠키값은 ${cookie.id.value} 입니다              EL코드 사용 후 위 패턴을 이 한줄로 요약시킴
</body>
</html>
