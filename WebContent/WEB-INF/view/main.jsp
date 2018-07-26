<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!doctype html>
<html lang="en">
<jsp:include page="common/head.jsp" />
<body>
	<div id="wrapper"></div>
	<div id="header">
		<jsp:include page="common/titleBox.jsp" />
		<jsp:include page="common/loginBox.jsp" />
		<jsp:include page="common/menuBox.jsp" />
	</div>

	<!-- 		header end -->
	<div id="content">
		<jsp:include page="common/contentBox.jsp" />
	</div>
	<!-- 		content end -->
	<div id="footer"></div>
	<jsp:include page="common/footerBox.jsp" />
<script>
		function move(domain, action, page) {
			alert('클릭 테스트 성공${ctx}');
			console.log('클릭 테스트 성공${ctx}')
			location.href = "${ctx}/" + domain + ".do?action=" + action
					+ "&page=" + page;
		}
		function sendForm(){
			return true;
		}
</script>
</body>
</html>

