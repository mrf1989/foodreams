<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="c3/c3.css" rel="stylesheet">
<title>fooDreams - Recetas</title>
</head>
<body>
	<h1>
		Resultados de recetas para:
		<c:out value="${param.q}" />
	</h1>
	<script src="https://d3js.org/d3.v5.min.js"></script>
	<script src="c3/c3.min.js"></script>
	<c:forEach items="${requestScope.recetas}" var="receta">
		<span>${receta.recipe.label}</span>
		<br>
		<% Long id = java.lang.Math.round(java.lang.Math.random() * 200) + 30; %>
		<c:set var="rand"><%= id %></c:set>
		<div id="chart${rand}"></div>
		<input id="${rand}" value="<c:out value="${rand}" />" type="hidden"/>
		<input id="val1${rand}" name="${rand}" value="<c:out value="${receta.recipe.totalNutrients.FAT.quantity}" />" type="hidden"/>
		<input id="val2${rand}" name="${rand}" value="<c:out value="${receta.recipe.totalNutrients.SUGAR.quantity}" />" type="hidden"/>
		<input id="val3${rand}" name="${rand}" value="<c:out value="${receta.recipe.totalNutrients.VITC.quantity}" />" type="hidden"/>
		<script>
			var selector = '#chart'+<%=id %>;
			var a = document.getElementsByName('<%=id %>')[0].value;
			var b = document.getElementsByName('<%=id %>')[1].value;
			var c = document.getElementsByName('<%=id %>')[2].value;
			
			var chart = c3.generate({
				bindto: selector,
				data: {
					x: 'x',
					columns: [
						['valores nutric', a, b, c],
						['x','cal','sugar','vitC']
					]
				},
				axis: {
					x: {
						type: 'category'
					}
				}
			});
		</script>
		<form action="VideosController" method="get">
			<input type="hidden" name="q" value="${receta.recipe.label}">
			<button type="submit">Videos</button>
		</form>
	</c:forEach>
	
	<form action="PhotosController" method="get">
		<input type="hidden" name="q" value="${param.q}">
		<button type="submit">Fotos</button>
	</form>
	<div id="chart1"></div>
	<p><a href="/">Volver</a></p>

</body>
</html>