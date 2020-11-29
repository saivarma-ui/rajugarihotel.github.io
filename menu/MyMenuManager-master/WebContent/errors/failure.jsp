<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../templates/head.jsp"%>
		<title>Failure</title>
	</head>
	<body>
		<%@ include file="../../templates/navbar.jsp"%>
		
		<div class="container">
			<h1>Failure</h1>
	
			<p>Oops ! It looks like we are not able to reach the server !</p>
			<p>Please retry later. If after a few minutes, the service still not work, <a href="mailto:team@mymenumanager.com">please contact us</a>. </p>				
		</div>
		<%@ include file="../../templates/foot.jsp"%>
	</body>
</html>


