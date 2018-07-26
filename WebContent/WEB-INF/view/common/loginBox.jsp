<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="login-box">
	<a id="moveLoginForm" >LOGIN</a>
	&nbsp;&nbsp;&nbsp; 
	<a id="moveJoinForm" >JOIN</a><br />
	<br />
	<a id="movedeleteForm">회원탈퇴</a>
</div>

<!-- <script>
	var common = new common();
	common.move();
</script> -->
<script>
	// var moveLoginForm = document.getElementById('moveLoginForm');
	document.getElementById('moveLoginForm').addEventListener('click',function(){ //콜백함수
		alert('로그인 클릭 이벤트 체크!'+'${ctx}');
		new Common().move('${ctx}','member','move','user_login_form');
	});
	
	document.getElementById('moveJoinForm').addEventListener('click',function(){
		alert('조인 클릭 이벤트 체크');
		new Common().move('${ctx}','member','move','joinForm');
	});
	document.getElementById('movedeleteForm').addEventListener('click',function(){
		common.move('member','move','deleteForm');
	})
		
</script>