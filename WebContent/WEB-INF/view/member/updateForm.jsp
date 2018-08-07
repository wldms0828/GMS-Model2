<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<form id="updateForm" name="updateForm" action="${ctx}/member.do">
<table id ="mypage">
  <tr>
    <td colspan="2" rowspan="3">
	<img src="${img}/mypage/로그인.PNG"></img></td>
    <td >ID</td>
    <td colspan="3">${user.userId}</td>
  </tr>
  <tr>
    <td >이름</td>
    <td colspan="3">${user.name}</td>
  </tr>
  <tr>
    <td >비밀번호</td>
    <td colspan="3">
	변경 비밀번호<input type="text" name="NEWPASSWORD" placeholder="*******" />
	기존 비밀번호<input type="text" name="PASSWORD" placeholder="*******" />
    </td>
    
  </tr>
  <tr>
    <td colspan="2">나이</td>
    <td >${user.age}</td>
    <td >팀명</td>
    <td  colspan="2">	
    <input type="radio" name="TEAM_ID" value="none" id="teamid_0" /> 없음
    <input type="radio" name="TEAM_ID" value="ateam" id="teamid_1"/> 걍놀자
	<input type="radio" name="TEAM_ID" value="hteam" id="teamid_2"/> 지은이네
	<input type="radio" name="TEAM_ID" value="steam" id="teamid_3"/> 왕거북이
	<input type="radio" name="TEAM_ID" value="cteam" id="teamid_4"/> 코딩짱</td>
  </tr>
  <tr>
    <td colspan="2">성별</td>
    <td >${user.gender}</td>
    <td >역할</td>
    <td colspan="2">
    <select name="ROLL" id="ROLL">
	<option value="leader" >팀장</option>
	<option value="front">프론트개발</option>
	<option value="back">백단개발</option>
	<option value="android">안드로이드개발</option>
	<option value="minfe">민폐</option>
	</select></td>
    
  </tr>
</table>
<input type="button" id="updateConfirmBtn" value="변경완료"/>
<!-- <input type="hidden" name="action" value="updatemember"/> -->
<!-- <input type="hidden" name="page" value="mypage" /> -->
	</form>
	
	<script>
	
	
	var team = document.getElementById('teamid');
	var roll = document.getElementById('ROLL');
	for(var i = 0;i<roll.options.length;i++){
		//alert(roll.options[i].value+'과 같다');
		if(roll.options[i].value==='${user.roll}'){
			roll.options[i].setAttribute("selected","selected");}
		}	
	for(var i=0;i<5;i++){
		if(document.getElementById('teamid_'+i).value==='${user.teamId}'){
			document.getElementById('teamid_'+i).checked=true;
		}	

	};
	document.getElementById('updateConfirmBtn')
	.addEventListener('click',function(){
	var x = service.nullChecker([document.updateForm.PASSWORD.value]);
	if(x.checker){
		var form = document.getElementById('updateForm');	
		var node = document.createElement('input');
// 		node.innerHTML=
// 			'<input type="hidden" name="action" value="updatemember"/>'
		node.setAttribute('type','hidden');
		node.setAttribute('name','action');
		node.setAttribute('value','updatemember');
			form.appendChild(node);
				form.action = "${ctx}/member.do";
				form.method = "post";
				form.submit();

	}else{
		alert(x.text);}}

</script>
</body>
</html>


