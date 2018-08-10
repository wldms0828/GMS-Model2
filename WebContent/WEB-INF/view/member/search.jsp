<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content-box">
	<div id="content-box-search">
		<select name="searchOption" id="searchOption">
			<option value="none">검색조건</option>
			<option value="USERID">ID검색</option>
			<option value="NAME">이름검색</option>
			<option value="TEAMID">팀명 검색</option>

		</select> <input type="text" placeholder="검색어 입력" id="search" name="search" />
		<input type="button" id="searchBtn" value="검색" />

	</div>
	<table id="contentBoxTab">
		<tr id="contentBoxMeta">
			<th>아이디</th>
			<th>이 름</th>
			<th>나 이</th>
			<th>성 별</th>
			<th>역 할</th>
			<th>팀아이디</th>
		</tr>
		<c:forEach items="${list}" var="member">
			<tr>

				<td>${member.userId}</td>
				<td><a class="username" id="${member.userId}">${member.name}</a></td>
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
				전체회원수 : ${page.count}
				<!-- 		list commander에 담아서 count command에서 리턴해준다. -->
				<%-- 		<c:forEach begin="1" end="${count}" step="1" var ="member1"> --%>
				<ul class="pagebox">
					<c:choose>
							<c:when test="${page.existPrev}">
					         	<li id="${page.prevBlock}" class="pageNum">◀이전</li>
					         </c:when>
							<c:otherwise>
							</c:otherwise>
					</c:choose>
					<c:forEach begin="${page.beginPage }" end="${page.endPage }"
						step="1" varStatus="i">
						<li><a id="${i.index}" class="pageNum" name="pageIndex">${i.index}</a>
						</li>
					</c:forEach>
					<c:choose>
						<c:when test="${page.existNext}">
				         	<li id="${page.nextBlock}" class="pageNum">다음▶</li>
				         </c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>


				</ul> <%-- 			<span>${member1}</span> --%> <%-- 		</c:forEach> --%> <!-- 		for loop은 index로 찾는 것 for each는 객체로 찾는 것  for each가 성능이 더 좋은데 가까운거 부터 가기 때문이다.-->
			</td>
		</tr>
	</table>

</div>
<script>
	admin.main('${ctx}');

</script>