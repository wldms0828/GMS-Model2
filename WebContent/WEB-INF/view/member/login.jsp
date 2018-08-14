<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="content-box">
<jsp:include page="../common/head.jsp" />

<div id = "user-login-layout">
<h1>로그인</h1>
<form id = "user_login_form" name="user_login_form" style = "border:1px solid black">
	ID :<br />
	<input type="text" name="USERID"  />
	<br />
	PASSWORD:	<br />
	<input type="text" name="PASSWORD" />
	<br />
	<input id="loginFormBtn" type="button" value ="전송"/>
</form>
</div>
</div>	
