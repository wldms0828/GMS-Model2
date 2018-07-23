<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "domain.*" %>
    <% 
	MemberBean user = (MemberBean)request.getAttribute("user");
%>
<hi><%=user.getName() %>의 마이페이지 진입</hi>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Hello</title>
	<link rel="stylesheet" href="../../css/style.css" />
	<style >
	
	</style>
</head>
<body id = "background">

	<table class = "width-full height-full margin-auto ">
		<tr>
			<th colspan="2">GMS</th>
		
		</tr>
		<tr>
			<td>
			<a href="">
		<img src="../../img/home/login.png" alt="" />
		</a><br />
			</td>
			<td class = "width-30"> <a href="../home/main.html">로그아웃</a> </td>
		</tr>
		<tr>
			<td colspan = "2">주소</td>
	
		</tr>
	</table>
</body>
</html>