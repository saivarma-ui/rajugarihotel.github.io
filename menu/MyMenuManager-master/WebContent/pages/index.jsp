<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>






<!DOCTYPE html>

<html lang="fr">

	<head>
		<%@ include file="../templates/head.jsp"%>
		<style>
		
			@font-face {
    			font-family: 'Amontillados';
    			src: url('/fonts/Amontillados.ttf') format('ttf');
    		}
    		
			body {
				background-image: url("${pageContext.servletContext.contextPath}/imageB/restaurant.jpg") ;
				background-size: cover;
				background-repeat: no-repeat;
			}
			h1 {
			    font-family: 'Amontillados', Arial, serif;
				text-align : center;
				color: white;
			}
		</style>
		<title>Accueil</title>
	</head>
	<body>
		<%@ include file="../../templates/navbar.jsp"%>
		<div class="container">
			<h1>My Menu Manager</h1>
		</div>
		<%@ include file="../templates/foot.jsp"%>
	</body>
</html>