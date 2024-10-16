<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<form action="${pageContext.request.contextPath}/admin/video/insert"
	method="post" enctype="multipart/form-data">
	<label for="fname">Video ID:</label><br> <input type="text"
		name="videoid" value="${vid.videoId}"><br>
	<c:url value="/upload/${cate.images}" var="imgUrl"></c:url>
	<label for="lname">Upload poster:</label><br> <input type="file"
		id="images" name="images"><br> <label for="fname">Video
		Title:</label><br> <input type="text" name="title" value="${vid.title}"><br>
	<label for="fname">Description:</label><br> <input type="text"
		name="description" value="${vid.description}"><br> <label
		for="fname">Views:</label><br> <input type="text" name="views"
		value="${vid.views}"><br> <label for="fname">Category:</label><br>
	<select name="category" id="category">
		<c:forEach var="cat" items="${categories}">
			<option value="${cat.categoryid}"
				${vid.category.categoryid == cat.categoryid ? 'selected' : ''}>
				${cat.categoryname}</option>
		</c:forEach>
	</select><br> <label for="html">Status</label><br> <input type="radio"
		id="ston" name="active" value="1" checked> <label for="ston">Hoạt
		động</label><br> <input type="radio" id="stoff" name="active" value="0">
	<label for="stoff">Khóa</label> <br> <input type="submit"
		value="Insert">
</form>