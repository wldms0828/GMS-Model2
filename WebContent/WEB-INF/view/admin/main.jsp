<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<div id="wrapper"></div>
	<div id="header">
		<jsp:include page="../common/titleBox.jsp" />
	</div>
	<jsp:include page="menuBox.jsp" />
	<!-- 		header end -->
	<div id="content">
		<jsp:include page="../common/contentBox.jsp" />
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

