<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../../templates/head.jsp"%>
	<link href="${pageContext.servletContext.contextPath}/dropzone/dist/min/dropzone.min.css" rel="stylesheet" type="text/css"/>
	<title>Delete ${dish.name}</title>
</head>
<body>
	<%@ include file="../../templates/navbar.jsp"%>
	<div class="container">
		<c:if test="${formError}">
			<p class="alert alert-danger">${formError}</p>
		</c:if>
		<form method="post" action="${pageContext.servletContext.contextPath}/admin/dish/delete?id=${dish.id}">
			<p class="alert alert-warning">
				<i class="text-warning fa fa-exclamation-triangle" aria-hidden="true"></i>
				Do you really want to delete the dish : <strong>${dish.name}</strong> ? It will be deleted permanently.
			</p>
			<a class="btn btn-default" href="${pageContext.servletContext.contextPath}/admin/dish">
				<i class="fa fa-chevron-left" aria-hidden="true"></i>
				Back
			</a>
			<button type="submit" class="btn btn-danger">
				<i class="fa fa-trash" aria-hidden="true"></i>
				Delete
			</button>
		</form>
	</div>
	
	<%@ include file="../../templates/foot.jsp"%>
</body>
</html>