<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*,pro0720study.*"%>
    
    
    <%
    request.setCharacterEncoding("utf-8");
    List membersList =new ArrayList();
    
    MemberBean m1 =new MemberBean("lee","1234","이순신","lee@test.com");
    MemberBean m2 = new MemberBean("kang","1234","현웅","gusdnd31%2sandw.com");
    membersList.add(m1);
    membersList.add(m2);
    request.setAttribute("membersList", membersList);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <jsp:forward page="member3.jsp"></jsp:forward>

</body>
</html>