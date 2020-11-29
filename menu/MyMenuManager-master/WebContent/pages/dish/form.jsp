<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
             
<c:if test="${!form.hasErrors() && form.isSubmitted()}">
	<p class="alert alert-success">
		The dish has been successfully saved.
	</p>
</c:if>

<form class="form-horizontal" method="POST">
	
	<div class="form-group <c:if test="${form.errors.get(form.name)!=null}">has-error</c:if>">
		<label for="name" class="col-sm-2 control-label">Name</label> 
		<div class="col-sm-10">
			<input name="${form.name}" value="${form.value(form.name)}" type="text" id="name" class="form-control" required autofocus>
			<p class="text-danger">${form.errors.get(form.name)}</p>
		</div> 
	</div>
	
	<div class="form-group <c:if test="${form.errors.get(form.description)!=null}">has-error</c:if>">
		<label for="description" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-10"> 
			<textarea id="description" name="${form.description}" class="form-control" rows="3">${form.value(form.description)}</textarea>
			<p class="text-danger">${form.errors.get(form.description)}</p>
		</div> 
	</div>
	
	<div class="form-group <c:if test="${form.errors.get(form.price)!=null}">has-error</c:if>">
		<label for="price" class="col-sm-2 control-label">Price</label>
		<div class="col-sm-10"> 
			<div class="input-group">
      			<div class="input-group-addon">€</div>
				<input name="${form.price}" value="${form.value(form.price)}" type="number" id="price" class="form-control" required>
			</div>
			<p class="text-danger">${form.errors.get(form.price)}</p>
		</div> 
	</div>
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-2">
			<button class="btn btn-primary btn-block" type="submit">Save</button>
		</div>
		<div class="col-sm-2">
			<button class="btn btn-default btn-block" type="reset">Reset</button>
		</div>
	</div>
</form>
