<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored ="false"
    import ="java.util.*,beanTest.*"%>
    
    
    <%
    request.setCharacterEncoding("utf-8");
    %>
    
    <jsp:useBean id ="m1"  scope ="request" class="beanTest.BoardBean" />
    <jsp:setProperty name ="m1" property ="*" />
    <jsp:useBean id ="membersMap"  class="java.util.HashMap" />    
    <jsp:useBean id ="memberList"  class="java.util.ArrayList" />
    <%
    membersMap.put("id","park2");
    membersMap.put("pwd","4321");
    membersMap.put("name", "박지성");
    membersMap.put("email", "park@test.com");
    
    MemberBean m2 = new MemberBean("son","1234","손흥민","son@Test.ddsd");
    memberList.add(m1);
    memberList.add(m2);
    membersMap.put("memberList", memberList);
    %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <table border=1 align ="center">
    <tr align ="center" bgcolor="#99ccff">
    <td width="20%"><b>아이디</b></td>
    <td width="20%"><b>비밀번호</b></td>
    <td width="20%"><b>이름</b></td>
    <td width="20%"><b>이메일</b></td>
   </tr> 
   <tr align ="center">
   <td>${membersMap.id} </td>
   <td>${membersMap.pwd} </td>                            
   <td>${membersMap.name} </td>                           
   <td>${membersMap.email} </td>
   </tr>
    <tr align ="center">
   <td>${membersMap.memberList[0].id} </td>
   <td>${membersMap.memberList[0].pwd} </td>
   <td>${membersMap.memberList[0].name} </td>
   <td>${membersMap.memberList[0].email} </td>
   </tr>
   <tr align ="center">
   <td>${membersMap.memberList[1].id} </td>
   <td>${membersMap.memberList[1].pwd} </td>
   <td>${membersMap.memberList[1].name} </td>
   <td>${membersMap.memberList[1].email} </td>
   </tr>
   </table>


</body>
</html>