<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content-box">
<div id="content-box-search">
	<select name="searchOption" id="searchOption">
	<option value="none">검색조건</option>
	<option value="USERID">ID검색</option>
	<option value="NAME">이름검색</option>
	<option value="TEAMID">팀명 검색</option>

	</select>
	<input type="text" placeholder="검색어 입력" id="search" name="search"/>
	<input type="button" id="searchBtn" value="검색" />

</div>
	<table id="contentBoxTab">
		<tr id="contentBoxMeta">
			<th>아이디</th>
			<th>이   름</th>
			<th>나   이</th>
			<th>성   별</th>
			<th>역   할</th>
			<th>팀아이디</th>
		</tr>
		<c:forEach items="${list}" var="member">
		<tr>
	
			<td>${member.userId}</td>
			<td><a class="username" id="${member.userId}" >${member.name}</a></td>
<%-- 			class="username" 는 값이고, id="${member.userId}는 객체이기 때문에 id 값이 중복안된다. --%>
<%-- 이렇게 하지말자  <td><a style="cursor: pointer;" href="${ctx}/admin.do?action=retrieve&page=memberDetail&USERID=${member.userId}" >${member.name}</a></td> --%>
			<td>${member.age}</td>
			<td>${member.gender}</td>
			<td>${member.roll}</td>
			<td>${member.teamId}</td>
<!-- 			loombok으로 getter,setter생략  -->
		</tr>
		</c:forEach>

		<tr>
		<td colspan="6">
		전체회원수 : ${count}
<!-- 		list commander에 담아서 count command에서 리턴해준다. -->
<%-- 		<c:forEach begin="1" end="${count}" step="1" var ="member1"> --%>
<ul class="pagebox">
		<c:forEach begin="${beginPage }" end="${endPage }" step="1" varStatus="i">
		<li>
		<a id="${i.index}" class="pageNum" name="pageIndex">${i.index}</a>		
		</li>
		</c:forEach>
      <c:choose>
         <c:when test = "${count gt 25}">
         	다음▶
         </c:when>
         <c:otherwise>
		 </c:otherwise>
	</c:choose>

		
</ul>


<%-- 			<span>${member1}</span> --%>
<%-- 		</c:forEach> --%>
<!-- 		for loop은 index로 찾는 것 for each는 객체로 찾는 것  for each가 성능이 더 좋은데 가까운거 부터 가기 때문이다.-->
		</td>
		</tr>
	</table>
	
</div>
<script>
	admin.main('${ctx}');
//list는 페이지 들어가자 마자 목록이 떠야하기 때문에 click없이 해야됌
//app.js로 이동
// 	document.getElementById('contentBoxMeta').className='bgColorIs ';
// 	document.getElementById('contentBoxTab').className='marginAuto';
// 	document.getElementById('contentBoxTab').className='width80';
// 	document.getElementById('contentBoxTab').className='height100px';
// 	document.getElementById('content-box-search').className='width90';
// 	document.getElementById('content-box-search').className='marginAuto';
// service.addClass(
// 		document.getElementById('contentBoxMeta'),'bgColorIs '
// );
// service.addClass(
// 		document.getElementById('contentBoxTab'),'marginAuto width80 height100px'
// );
// service.addClass(
// 		document.getElementById('content-box-search'),'width90 marginAuto'
// );



// // 	자바스크립트의 타입 primitive type과 reference type 으로 나뉜다. 객체지향 언어는 type이 크게 두개로 나뉜다.
// //	var x = document.getElementById('aaa'); 이것은 객체이고
// //  var x = document.querySelectAll('.username');은 class를 던졌기 때문에  Array이다.
// 	document.getElementById('searchBtn').addEventListener('click',function(){
// // 		if(){
// // 			location.href = '${ctx}/admin.do?action=retrieve&page=memberDetail&USERID'+;
// // 		}else{
// // 			location.href = '${ctx}/admin.do?action=searchbyname&page=main&searchOption='+'&searchOption';
// // 		} // 삼항으로 변환한 것이 아래의 형태로 됌


// 		location.href =
// 		(document.getElementById('searchOption').value==='USERID')?
// 		'${ctx}/admin.do?action=retrieve&page=memberDetail&USERID='+ document.getElementById('search').value

// 		:
// 		'${ctx}/admin.do?action=searchbyname&page=memberDetail&searchOption='+ document.getElementById('search').value +'&searchOption'+ document.getElementById('search').value ;
// 	});
// 	var x = document.querySelectorAll('.username');
// 	for(i in x){
// 		x[i].className='fontColor';
// 		x[i].className='cursor';
// 		x[i].addEventListener('click',function(){
// 			alert('클릭'+this.getAttribute('id'));
// 			location.href = 
// 				"${ctx}/admin.do?action=retrieve&page=memberDetail&USERID="+this.getAttribute('id');
			
// 			//자바에서의 this는 필드값이고,
// 			//addEventListener(콜백함수)에서 내부에서 this는 최초에 호출되는 객체(x[i]) 하나 이다.
// 		})
// 	}
</script>