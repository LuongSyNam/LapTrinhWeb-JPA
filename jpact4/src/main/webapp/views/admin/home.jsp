<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	trang chủ của admin
	<form action="/ltwebct4/user/home" method="post">
		<div class="container">
			<button type="logout">Logout</button>
			<a href="${pageContext.request.contextPath }/admin/categories">Categories</a>
		</div>
	</form>
</body>
</html>