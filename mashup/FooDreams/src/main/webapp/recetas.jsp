<%@page import="aiss.model.edamam.Hit"%>
<%@page import="aiss.model.flickr.Photos"%>
<%@page import="java.util.List"%>
<%@page import="aiss.model.flickr.FotoSearch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Resultados de recetas para:
		<c:out value="${param.q}" />
	</h1>
	<%
		List<Hit> recetas = (List<Hit>)request.getAttribute("recetas");
		String nombre = (String)request.getAttribute("nombre");
		request.getSession().setAttribute("recetas", nombre);
	%>
	<c:forEach items="${requestScope.recetas}" var="receta">
		<span>${receta.recipe.label}</span>
		<br>
		<form action="VideosController" method="get">
			<input type="hidden" name="q" value="${receta.recipe.label}">
			<button type="submit">Videos</button>
		</form>
	</c:forEach>
	<form action="PhotosController" method="get">
		<input type="hidden" name="q" value="${param.q}">
		<button type="submit">Fotos</button>
	</form>
	<p>
		<a href="/">Volver</a>
	</p>
</body>
</html>