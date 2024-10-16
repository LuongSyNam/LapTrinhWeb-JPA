<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "jakarta.tags.core" %>

<form action = "${pageContext.request.contextPath}/admin/category/update" method="post" 
		enctype="multipart/form-data">
  <input type="text" id="categoryid" name="categoryid" value="${cate.categoryid }" hidden="hidden"><br> 
  <label for="categoryname">Category name:</label><br>
  <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br>
  <label for="images">Images:</label><br>
  	<c:if test = "${cate.images.substring(0,5) != 'https' }">
					<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
				</c:if>
				<c:if test = "${cate.images.substring(0,5) == 'https' }">
					<c:url value="${cate.images }" var="imgUrl"></c:url>
				</c:if>
				<img height="150" width="200" src="${imgUrl}" />
				
  <input type="file" onchange = "choosefile(this)" id="images" name="images" value="${cate.images}"><br>
  
  <p> Status: </p>
  <input type="radio" id="ston" name="status" value="1" ${cate.status == 1?'checked':''} ><br>
  <label for="html">Đang hoạt động</label><br> 
  <input type="radio" id="stoff" name="status" value="0" ${cate.status != 1?'checked':''}><br>
  <label for="css">Khóa</label><br>
  <br> <input type="submit" value="update">	 	 
</form>