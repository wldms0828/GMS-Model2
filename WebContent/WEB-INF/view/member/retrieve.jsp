<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />

<body>
<%-- 		<h1>${user.name}의 마이페이지 진입</h1> --%>
<!-- 	<!-- String USERID = user.getUserid(); -->
<%-- 	<h1>아이디 : ${user.userId}</h1> --%>
<!-- 	<h1>비밀번호 : ******</h1> -->
<%-- 	<h1>성별 : ${user.gender}</h1> --%>
<%-- 	<h1>팀명 : ${user.teamId}</h1> --%>
<%-- 	<h1>나이 : ${user.age}</h1> --%>
<%-- 	<h1>주민번호 : ${user.ssn}</h1> --%>
<div id="content-box">
<table id ="mypage">
  <tr>
    <td colspan="2" rowspan="3">
     <img src="${img}/mypage/로그인.PNG"></img></td>
    <td  >ID</td>
    <td colspan="3">${member.userId}</td>
  </tr>
  <tr>
    <td >이름</td>
    <td colspan="3">${member.name}</td>
  </tr>
  <tr>
    <td >비밀번호</td>
    <td colspan="3">*******</td>
  </tr>
  <tr>
    <td colspan="2">나이</td>
    <td >${member.age}</td>
    <td >팀명</td>
    <td  colspan="2">${member.teamId}</td>
  </tr>
  <tr>
    <td colspan="2">성별</td>
    <td >${member.gender}</td>
    <td >역할</td>
    <td colspan="2">${member.roll}</td>
    
  </tr>
</table>
</div>
	<a id="mypageMoveToUpdate"><input type="button" value="UPDATE 수정" /></a>
	<a id="mypageMoveToDelete"><input type="button" value="DELETE 수정" /></a>
	
	<script>
	document.getElementById('mypageMoveToUpdate')
	.addEventListener('click',function(){
		router.move({ctx : '${ctx}',
			domain : 'member',
			action : 'move',
			page : 'updateForm'});
	});
	
	document.getElementById('mypageMoveToDelete')
	.addEventListener('click',function(){
		router.move({ctx : '${ctx}',
			domain : 'member',
			action : 'move',
			page : 'deleteForm'});
	});
</script>
</body>
</html>

