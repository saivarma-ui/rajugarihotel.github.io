<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../../templates/head.jsp"%>
	<link href="${pageContext.servletContext.contextPath}/dropzone/dist/min/dropzone.min.css" rel="stylesheet" type="text/css"/>
	<title>Edit ${dish.name}</title>
	<style>
		div#picture {
			margin-bottom: 20px;
		}
	</style>
</head>
<body>
	<%@ include file="../../templates/navbar.jsp"%>
	<div class="container">
		<h2>Edit ${dish.name} :</h2>
		<%@ include file="form.jsp"%>
		
		<h2>Set an image</h2>
		<h3>Current image :</h3>
		<img src="${pageContext.servletContext.contextPath}/admin/image/get?id=${dish.id}" alt="no image"/>
		<form id="picture" action="${pageContext.servletContext.contextPath}/admin/image?id=${dish.id}" class="dropzone" method="POST" enctype="multipart/form-data"></form>
	</div>
	
	<%@ include file="../../templates/foot.jsp"%>
	<script src="${pageContext.servletContext.contextPath}/dropzone/dist/min/dropzone.min.js"></script>
	<script type="text/javascript">

	</script>
</body>
</html>