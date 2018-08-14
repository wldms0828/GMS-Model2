<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="content-box">
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
		</div>
	<script>



document.getElementById('joinFormBtn')
 		.addEventListener('click',function(){

 			var form = document.getElementById('joinForm');	
 			var x = service.nullChecker([document.joinForm.USERID.value
 				,document.joinForm.PASSWORD.value		
 				,document.joinForm.NAME.value]);
 			if(x.checker){
 				
 				member.join(form.SSN.value);
 				var arr = [
 	 				{name:'GENDER', value:member.getGender()},
 	 				{name:'AGE', value:member.getAge()},
 					{name:'action',value:'add'},
 					{name:'page',value:'login'}
 					];
 				
 	 			for(var i in arr){
 				var node = document.createElement('input');	
 					node.setAttribute('type','hidden');
 	 				node.setAttribute('name',arr[i].name);
 	  				node.setAttribute('value',arr[i].value);
 					form.appendChild(node);
 				}
 	 			form.action = "${ctx}/member.do";
 				form.method = "post";	
				form.submit();
 				}else{
 	 				alert(x.text);}
 	   		
 	 			});

	</script>
