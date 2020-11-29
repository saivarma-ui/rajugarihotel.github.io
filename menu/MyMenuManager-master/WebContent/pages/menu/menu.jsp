<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
             


<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../templates/head.jsp"%>
		<title>Dishes List</title>
	</head>
	<body>
		<%@ include file="../../templates/navbar.jsp"%>
		<div class="container">
		<a href="${pageContext.servletContext.contextPath}/menu/pdf"><input type="button" value="Télécharger Menu"></a>			
		<c:forEach var="dish_group" items="${dish_groups}">
			        <ul> <h3>${dish_group.name}</h3>	
			        	<c:forEach var="dish" items="${dish_group.getDishes()}">
			        	      <li>
			        	      	${dish.name} 
			        	 		${dish.price} €
			        	      </li>      
			        	 </c:forEach>              
			        </ul>
		</c:forEach>
			        	<c:forEach var="dish" items="${dishes}">
			        	      <li>
			        	      		${dish.name} (pas de groupe)
			        	      </li>      
			        	 </c:forEach>  

		
					
		</div>		
	<%@ include file="../../templates/foot.jsp"%>
	<script type="text/javascript" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
	<script> 
		$(document).ready(function(){
		    $('#myTable').DataTable();
		});
	</script>
	</body>
</html>



