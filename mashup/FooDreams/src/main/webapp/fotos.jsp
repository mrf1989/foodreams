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
		<h2>Fotos sobre: <c:out value="${param.q}"/></h2>
		<div class="row">
		<c:forEach items="${requestScope.fotos}" var="foto">
		<% Integer i = 3; %>
		<% if (i > 0) { %>
			<div class="col-md-6 col-sm-12">
				<div class="card">
					<img src="https://farm${foto.farm}.staticflickr.com/${foto.server}/${foto.id}_${foto.secret}.jpg" />				
				</div>
			</div>		
		<% i = i - 1; } else { i = 3; } %>
		</c:forEach>
		</div>
		<p><a href="/">Volver</a></p>
	</div>
<%@ include file="includes/footer.jsp" %>