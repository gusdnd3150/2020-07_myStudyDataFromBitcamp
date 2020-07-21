<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
    import="study09.*"
    pageEncoding="UTF-8"
%>
<jsp:useBean  id="vo"  class="study09.MemberVO"  scope="request"/> 
<%
   request.setCharacterEncoding( "utf-8" );
   //MemberVO vo = (MemberVO)request.getAttribute("vo");
   String command = (String)request.getAttribute("command");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" method="post" action="/WebStudy/member" encType="UTF-8">
	ID :<input type="text" name="id" value=<jsp:getProperty  name="vo" property="id" />><br>
	비밀번호 :<input type="text" name="pwd" value=<jsp:getProperty  name="vo" property="pwd" />><br>
	이름 :<input type="text" name="name" value=<jsp:getProperty  name="vo" property="name" />><br>
	이메일:<input type="text" name="email" value=<jsp:getProperty  name="vo" property="email" />><br>
<%
    if("modSearch".equals(command)){
%>	
	<input type="submit" name='submit' value="수정">
	<input type='hidden' name='command' value='modUpdate'   /> 
<%  } %>	
<%
    if("addSearch".equals(command)){
%>	
	<input type="submit" name='submit' value="추가"> 
	<input type='hidden' name='command' value='addInsert'   />
<%  } %>	
	
	</form>
</body>
</html>