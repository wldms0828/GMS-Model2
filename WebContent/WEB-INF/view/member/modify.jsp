<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="content-box">
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
	
	</div>
<form method="POST" enctype="multipart/form-data" 
action="${ctx}/member.do?action=fileupload&page=retrieve">
  파일업로드: <input type="file" name="upfile"><br/>
  <br/>
  <input type="submit" value="파일업로드">
  <input type="hidden" name="action" value="fileupload"/>
  <input type="hidden" name="page" value="retrieve" />
</form>	



