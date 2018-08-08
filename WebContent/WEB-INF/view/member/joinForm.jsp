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
	<input id="SSN" type="text" name="SSN" /><br />
	ID : <br />
	<input type="text" name="USERID" /><br />
	PASS : <br />
	<input type="text" name="PASSWORD" /><br />
	<br />

<!-- 	<input type="hidden" name = "action" value = "join"> -->
<!-- 	<input type="hidden" name = "page" value = "joinResult" /> -->
<!-- 	<input type="hidden" name = "AGE" /> -->
<!-- 	<input type="hidden" name = "GENDER" /> -->

	소속팀

	<input type="radio" name="TEAM_ID" value="ateam" /> 걍놀자
	<input type="radio" name="TEAM_ID" value="hteam" /> 지은이네
	<input type="radio" name="TEAM_ID" value="steam" /> 왕거북이
	<input type="radio" name="TEAM_ID" value="cteam" /> 코딩짱
	<br />
	<br />
	
	프로젝트역할
	<select name="ROLL" id="ROLL">
	<option value="leader">팀장</option>
	<option value="front">프론트개발</option>
	<option value="back">백단개발</option>
	<option value="android">안드로이드개발</option>
	<option value="minfe">민폐</option>
	</select>
	<br />
	<br />
	수강과목
	<input type="checkbox" name="subject" value="java" checked="checked" />JAVA
	<input type="checkbox" name="subject" value="clang"  />C언어
	<input type="checkbox" name="subject" value="JSP"  />JSP
	<input type="checkbox" name="subject" value="PHP"  />PHP 
	<input type="checkbox" name="subject" value="nodejs"  />NodeJS
	<input type="checkbox" name="subject" value="linux"  />Linux
	<input type="checkbox" name="subject" value="html"  />HTML
	<input type="checkbox" name="subject" value="Spring"  />Spring
	<br />
	<br />
	<input id="joinFormBtn" type="button" value="전 송" />
	
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



 		document.getElementById('joinFormBtn')
 		.addEventListener('click',function(){
// 			//var member = new Member();
// 			//var form = document.getElementById('user_login_form');	
 			var form = document.getElementById('joinForm');	
 			var x = service.nullChecker([document.joinForm.USERID.value
 				,document.joinForm.PASSWORD.value		
 				,document.joinForm.NAME.value]);
 			if(x.checker){
 				
 				member.join(form.SSN.value);
 				var arr = [
 	 				{name:'GENDER', value:member.getGender()},
 	 				{name:'AGE', value:member.getAge()},
 					{name:'action',value:'join'},
 					{name:'page',value:'user_login_form'}
 					];
 				
 	 			for(var i in arr){
 				var node = document.createElement('input');	
 					node.setAttribute('type','hidden');
 	 				node.setAttribute('name',arr[i].name);
 	  				node.setAttribute('value',arr[i].value);
 					form.appendChild(node);
 				}
 	 			//input tag를 만든것 
 	 			form.action = "${ctx}/member.do";
 				form.method = "post";	
				form.submit();
 				}else{
 	 				alert(x.text);}
 	   		
 	 			});
//				var node = document.createElement('input');
//				node.innerHTML=
//  				'<input type="hidden" name="action" value="join"/>';
// 				node.setAttribute('type','hidden');
// 				node.setAttribute('name','action');
// 				node.setAttribute('value','join');
// 				form.appendChild(node);
// 				var node1 = document.createElement('input');
//  				node.innerHTML=
//  					'<input type="hidden" name="GENDER"/>';
// 				node1.setAttribute('type','hidden');
// 				node1.setAttribute('name','GENDER');
// 				form.appendChild(node1);
// 				var node2 = document.createElement('input');
//  			node.innerHTML=
//  				'<input type="hidden" name="AGE"/>';
// 				node2.setAttribute('type','hidden');
// 				node2.setAttribute('name','AGE');
// 				form.appendChild(node2);
//              배열 				
//  			var arr = ['action','GENDER','AGE'];
// 			var arr1 =['join'];
//  			for(var i=0;i<arr.length;i++){
// 			node.setAttribute('type','hidden');
//  				node.setAttribute('name',arr[i]);
//  				node.setAttribute('value',arr1[i]);
// 				form.appendChild(node);
			
		
		//할당 하는건 아주 나쁜 코딩이다 나중엔 할당도 하지 않고 등호나 연산기호 역시 사용하지 않을것이다.
	</script>
</body>
</html>