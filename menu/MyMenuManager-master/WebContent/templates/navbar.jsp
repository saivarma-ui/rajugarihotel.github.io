<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="${pageContext.servletContext.contextPath}" class="navbar-brand" href="#">My Menu Manager</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li>
					<a href="${pageContext.servletContext.contextPath}/menu">
						<i class="fa fa-cutlery" aria-hidden="true"></i> Menu
					</a>
				</li>
				<c:if test="${sessionScope.user != null}">
					<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
			            <i class="fa fa-lock" aria-hidden="true"></i> Administration
			          	<span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="${pageContext.servletContext.contextPath}/admin/dish">List dishes</a></li>
			            <li><a href="${pageContext.servletContext.contextPath}/admin/dish/create">Create a dish</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="${pageContext.servletContext.contextPath}/admin/group/manage">Manage groups</a></li>
			          </ul>
			        </li>
				</c:if>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${sessionScope.user == null}">
						<li><a href="${pageContext.servletContext.contextPath}/login"><i class="fa fa-sign-in" aria-hidden="true"></i> Sign In</a></li>
					</c:when>
					<c:otherwise>
						<p class="navbar-text">Signed in as ${user.username}</p>
						<li><a href="${pageContext.servletContext.contextPath}/logout"><i class="fa fa-sign-out" aria-hidden="true"></i> Sign out</a></li>
				</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>