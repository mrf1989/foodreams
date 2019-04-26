<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>fooDreams - Fotos</title>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>
	<div class="container">
		<div class="row my-3">
			<div class="col-md-12">
				<h2>Fotos sobre: "<c:out value="${param.q}"/>"</h2>
			</div>
		</div>
		<div class="row">
		<c:forEach items="${requestScope.fotos}" var="foto">
		<% Integer i = 3; %>
		<% if (i > 0) { %>
			<div class="col-sm-6 col-md-4">
				<div class="card receta-module">
					<img class="img-fluid" src="https://farm${foto.farm}.staticflickr.com/${foto.server}/${foto.id}_${foto.secret}.jpg" />				
				</div>
			</div>		
		<% i = i - 1; } else { i = 3; } %>
		</c:forEach>
		</div>
	</div>
<%@ include file="includes/footer.jsp" %>