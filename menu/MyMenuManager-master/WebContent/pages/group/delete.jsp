<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../../templates/head.jsp"%>
	<link href="${pageContext.servletContext.contextPath}/dropzone/dist/min/dropzone.min.css" rel="stylesheet" type="text/css"/>
	<title>Delete ${group.name}</title>
</head>
<body>
	<%@ include file="../../templates/navbar.jsp"%>
	<div class="container">
		<c:if test="${formError}">
			<p class="alert alert-danger">${formError}</p>
		</c:if>
		<form method="post" action="${pageContext.servletContext.contextPath}/admin/group/delete?id=${group.id}">
			<p class="alert alert-warning">
				<i class="text-warning fa fa-exclamation-triangle" aria-hidden="true"></i>
				<span class="sr-only">Warning !</span>
				Do you really want to delete the group : <strong>${group.name}</strong> ? It will be deleted permanently.
			</p>
			<p class="alert alert-info">
				<i class="text-info fa fa-info-circle" aria-hidden="true"></i>
				<span class="sr-only">Information :</span>
				Delete a group <strong>will not</strong> delete dishes in it.
			</p>
			<a class="btn btn-default" href="${pageContext.servletContext.contextPath}/admin/group/manage">
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