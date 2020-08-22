<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
  
  function fn_process(){
	    var id = $("#t_id").val();           // 제이쿼리사용하여 접근
	    if(id==''){
	   	 alert("ID를 입력하세요");
	   	 return;
	    }
	    $.ajax({
	    	
	       type:"post",          //타입이다    
	       async:true,          
	       url:"json3",             //값 전달주소   
	       dataType:"text",             //값 타입
	       data: {id:id},                 //값
	       success:function (data,textStatus){ //데이터 전송이 성공할 경우 data로 JSON문자열이 들어온다    
           	var jsonInfo = JSON.parse(data);       //parse를 통해 JSON 문자열을 자바스크립트 객체로 바꾼다
        	var memberInfo ="회원 정보<br>";                  
             memberInfo += "<table border='solid'><tr align='center' bgcolor='red'><th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일</th>";
             for(var i in jsonInfo.member){
	             memberInfo += "<tr align ='center'><td>" + jsonInfo.member[i].id+"</td>";
	             memberInfo += "<td>" + jsonInfo.member[i].pwd+"</td>";
	             memberInfo += "<td>" + jsonInfo.member[i].name+"</td>";
	             memberInfo += "<td>" + jsonInfo.member[i].email+"</td>";
	             memberInfo += "<td>" + jsonInfo.member[i].joinDate+"</td>";
                 }
             $("#member").html(memberInfo);    
	       },
	    
	       error:function(data,textStatus){
	          alert("에러가 발생했습니다.");
	       },
	       complete:function(data,textStatus){
	          
	       }
	    });  //end ajax	 
	 }	
  
</script>
</head>
<body>
	<input type="text" id="t_id" />
	<input type="button" onClick="fn_process()" value="조회" />
	<br>
	<br>
	<div id="member"></div>



</body>
</html>
