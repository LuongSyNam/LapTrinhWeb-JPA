<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<a href="<c:url value="/admin/video/add"/>">Add Video</a>
<br>
<br>
<form action="${pageContext.request.contextPath}/admin/video/search"
	method="get">
	<input type="text" name="keyword" placeholder="Nhập từ khóa tìm kiếm">
	<input type="submit" value="Tìm kiếm">
</form>
<hr>
<table border="1" width="100%">
	<tr>
		<th>STT</th>
		<th>Video ID</th>
		<th>Poster</th>
		<th>Video Title</th>
		<th>Description</th>
		<th>Views</th>
		<th>Category</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${listvid}" var="vid" varStatus="STT">
		<tr>
			<td>${STT.index+1 }</td>
			<td>${vid.videoId }</td>
			<td><c:url value="/upload/${vid.poster}" var="imgUrl"></c:url> <img
				height="150" width="200" src="${imgUrl}" /></td>
			<td>${vid.title }</td>
			<td>${vid.description }</td>
			<td>${vid.views }</td>
			<td>${vid.category.categoryname }</td>
			<td>
				<c:if test="${vid.active==1 }"> Hoạt động</c:if> 
				<c:if test="${vid.active!=1 }"> Khóa </c:if>
			</td>
			<td>
			<a href="<c:url value='/admin/video/edit?id=${vid.videoId }'/>">Sửa</a>
				| <a href="<c:url value='/admin/video/delete?id=${vid.videoId }'/>">Xóa</a>
			</td>
		</tr>
	</c:forEach>
</table>