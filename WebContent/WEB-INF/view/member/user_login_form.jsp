<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx =application.getContextPath();
%>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>USER LOGIN</title>
<link rel="stylesheet" href="../../css/style.css" />
</head>

<body id = background>
<div id = "user-login-layout">
<h1>로그인</h1>
<form id = "user-login-layout" action="<%=ctx %>/member.do" style = "border:1px solid black">
	ID :
	<input type="text" name="USERID"  />
	<br />
	PASSWORD:
	<input type="text" name="PASSWORD" />
	<br />
	<input type="hidden" name = "action" value = "login" />
	<input type="hidden" name ="page" value="mypage" />
	<input type="submit" value ="전송"/>
</form>
</div>
</body>
</html>