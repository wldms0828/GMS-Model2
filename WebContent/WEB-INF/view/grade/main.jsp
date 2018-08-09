<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<div id="wrapper"></div>
	<div id="header">
	<h2>관리자 페이지</h2>
	<jsp:include page="../common/menuBox.jsp" />
	</div>
	<!-- 		header end -->
	<div id="content-box">
		<jsp:include page="../member/search.jsp" />
	</div>
	<!-- 		content end -->
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp" />
	</div>
	<script>
		function move(domain, action, page) {
			alert('도메인로그인성공${ctx}');
			console.log('도메인로그인성공${ctx}')
			location.href = "${ctx}/" + domain + ".do?action=" + action
					+ "&page=" + page;

		}
		function sendForm() {
			return true;
		}
	</script>
</body>
</html>

