<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import ="java.util.*,pro0720study.*"
    %>
 
    <%
    request.setCharacterEncoding("utf-8");
    %>
    <%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <h1>회원 정보 출력</h1>
		<%
	    request.setCharacterEncoding( "utf-8" );
	    MemberDAO dao = new MemberDAO();
		
		String id = request.getParameter("id");
		String search = request.getParameter("search");
		
		MemberBean memberVO = new MemberBean();           //VO 객체 호출
		List membersList = dao.listMembers();      
		
		%>
		<c:set var ="memberList" value ="<%= membersList%>" />
      
    <table border="1"  align="center" >
    <tr align="center" bgcolor="lightgreen">
      <td width="7%"><b>아이디</b></td>
      <td width="7%"><b>비밀번호</b></td>
      <td width="5%" ><b>이름</b></td>
      <td width="5%"><b>이메일</b></td>
    </tr>
    
    <c:forEach var="member" items="${memberList}" >	
   <tr align="center">
      <td>${member.id}</td>
      <td>${member.pwd}</td>
      <td>${member.name}</td>
      <td>${member.email}</td>
   </tr>
    </c:forEach>
    </table>

</body>
</html>