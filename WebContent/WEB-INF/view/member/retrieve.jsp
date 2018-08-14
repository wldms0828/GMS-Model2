<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div id="content-box">
<table id ="mypage">
  <tr>
    <td colspan="2" rowspan="3">
     <img src="${img}/${profile}"></img></td>
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
			page : 'modify'});
	});
	
	document.getElementById('mypageMoveToDelete')
	.addEventListener('click',function(){
		router.move({ctx : '${ctx}',
			domain : 'member',
			action : 'move',
			page : 'remove'});
	});

</script>


