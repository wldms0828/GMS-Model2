<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
<!--  userId, ssn, name, roll, teamId,password; -->
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body id = "background">
	<form id="joinForm" name="joinForm" >
	
	NAME : <br />
	<input type="text" name="NAME" /><br />
	주민등록번호 : <br />
	<input type="text" name="SSN" /><br />
	ID : <br />
	<input type="text" name="USERID" /><br />
	PASS : <br />
	<input type="text" name="PASSWORD" /><br />

	<input type="hidden" name = "action" value = "join">
	<input type="hidden" name = "page" value = "joinResult" />
	<input type="hidden" name = "AGE" />
	<input type="hidden" name = "GENDER" />
	<input id="joinFormBtn" type="button" value="전 송" />
	
	소속팀

	<input type="radio" name="TEAM_ID" value="ateam" /> 걍놀자
	<input type="radio" name="TEAM_ID" value="hteam" /> 지은이네
	<input type="radio" name="TEAM_ID" value="steam" /> 왕거북이
	<input type="radio" name="TEAM_ID" value="cteam" /> 코딩짱
	
	프로젝트역할
	<select name="ROLL" id="ROLL">
	<option value="leader">팀장</option>
	<option value="front">프론트개발</option>
	<option value="back">백단개발</option>
	<option value="android">안드로이드개발</option>
	<option value="minfe">민폐</option>
	</select>
	수강과목
	<input type="checkbox" name="subject" value="java" checked="checked" />JAVA
	<input type="checkbox" name="subject" value="clang"  />C언어
	<input type="checkbox" name="subject" value="JSP"  />JSP
	<input type="checkbox" name="subject" value="PHP"  />PHP 
	<input type="checkbox" name="subject" value="nodejs"  />NodeJS
	<input type="checkbox" name="subject" value="linux"  />Linux
	<input type="checkbox" name="subject" value="html"  />HTML
	<input type="checkbox" name="subject" value="Spring"  />Spring
	</form>
	<script>
// 		document.getElementById('joinFormBtn').addEventListener('click',function(){
// 			Member member = new Member();
// 			var form = document.getElementById('joinForm');
// 			form.action = "${ctx}/member.do";
// 			form.method = "post";
// 			var NAME = form.NAME.value;
// 			var SSN = form.SSN.value;
// 			var USERID = form.USERID.value;
// 			var PASSWORD = form.PASSWORD.value;
// 			member.setName(NAME);
// 			member.setSsn(SSN);
// 			member.setUserId(USERID);
// 			member.setPassword(PASSWORD);
// 			if(service.joinValidation(member)){
// 				form.submit();
// 			}
			
// 		});
		document.getElementById('joinFormBtn').addEventListener('click',function(){
			//var member = new Member();
			//var form = document.getElementById('user_login_form');	
			var x = service.nullChecker([document.joinForm.USERID.value
				,document.joinForm.PASSWORD.value		
				,document.joinForm.NAME.value]);
			if(x.checker){
				var form = document.getElementById('joinForm');	
				form.action = "${ctx}/member.do";
				form.method = "post";
				member.join(document.joinForm.SSN.value);
				form.GENDER.value = member.getGender();
				form.AGE.value = member.getAge();		
				alert(member.getAge()+member.getGender());
				form.submit();
		
			}else{
				alert(x.text);}
		});
	</script>
</body>
</html>