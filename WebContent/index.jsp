<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>
  
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>MAIN</title>
	<link rel="stylesheet" href="resources/css/style.css" />
	
</head>
<body id = "background">
	
	<h3>현재 회원 수</h3> <mark>20 </mark><h3>명</h3>
	<table class = "width-full height-full margin-auto ">
		<tr>
			<th colspan="2">GMS</th>
		
		</tr>
		<tr>
			<td>
			<a href="">
		<img src="resources/img/home/login.png" alt="" />
		</a><br />
			</td>
			
			<td class = "width-30 "> 
			<ul>
				<li><a href="<%=ctx %>/member.do?action=move&page=joinForm">회원가입</a></li> 
				<li><a href="<%=ctx %>/member.do?action=move&page=user_login_form">사용자로그인</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=admin_login">관리자로그인</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=updateForm">비밀번호 변경</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=deleteForm">회원탈퇴</a></li>
				<li><a href="<%=ctx %>/member.do?action=memberList&page=memberList">멤버전체목록</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=searchTeamForm">팀명으로 검색하기</a></li>
				<li><a href="<%=ctx %>/member.do?action=move&page=searchByIdForm">ID로 검색하기</a></li>
			</ul> </td>
		</tr>
		<tr>
			<td colspan = "2">주소</td>
	
		</tr>
	</table>
</body>
</html>

