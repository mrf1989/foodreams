<%@page import="aiss.model.flickr.FotoSearch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Resultados de recetas para: <c:out value="${param.q}"/></h1>
	<c:forEach items="${requestScope.recetas}" var="receta">
		<span>${receta.recipe.label}</span><br>
		<form action="VideosController" method="get">
			<input type="hidden" name="q" value="${receta.recipe.label}">
			<button type="submit">Videos</button>
		</form>
		
	</c:forEach>
	<h2>Fotos:</h2>
	<c:forEach items="${requestScope.fotos}" var="foto">
		<img src="https://farm${foto.farm}.staticflickr.com/${foto.server}/${foto.id}_${foto.secret}.jpg" />
	</c:forEach>
	<p><a href="/fotos.jsp">Fotos</a></p>
	<p><a href="/">Volver</a></p>
</body>
</html>