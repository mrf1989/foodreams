<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<html>
<head>
<title>fooDreams - Recetas</title>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>
	<div class="container">
		<div class="row my-3">
			<div class="col-md-12 py-2">
				<form class="d-flex justify-content-center" action="PhotosController" method="get">
					<input type="hidden" name="q" value="${sessionScope.q}">
					<button class="btn btn-primary btn-lg" type="submit"><i class="fas fa-images"></i> Fotos</button>
				</form>
			</div>
		</div>
		<div class="row my-3">
			<div class="col-md-12">
				<h2>Resultados sobre: "<c:out value="${sessionScope.q}"/>"</h2>
			</div>
		</div>
		<div class="row">
			<!-- Scripts para generar gráficos -->
			<script src="https://d3js.org/d3.v5.min.js"></script>
			<script src="c3/c3.min.js"></script>
			<% Integer i = 2; %>
			<c:forEach items="${requestScope.recetas}" var="receta">
			<!-- Módulo para cada resultado de búsqueda -->
			<% Long id = Math.round((Math.random() + Math.random()) * 200) + 20; %>
			<c:set var="rand"><%= id %></c:set>
				<% if (i > 0) { %>
				<div class="col-md-6 col-sm-12">
					<div class="card receta-module">
						<div class="card-body">
							<h4 class="card-title"><a href="${receta.recipe.url}" target="_blank">${receta.recipe.label}</a></h4>
							<ul class="nav nav-tabs" id="contentTabNav-${rand}" role="tablist">
				  				<li class="nav-item">
				    				<a class="nav-link active" id="nutrientes-tab-${rand}" data-toggle="tab" href="#graph-nutrientes-${rand}" role="tab" aria-controls="graph-nutrientes-${rand}" aria-selected="true">Nutrientes</a>
				  				</li>
					  			<li class="nav-item">
					    			<a class="nav-link" id="ingredientes-tab-${rand}" data-toggle="tab" href="#list-ingredientes-${rand}" role="tab" aria-controls="list-ingredientes-${rand}" aria-selected="false">Ingredientes</a>
					  			</li>
							</ul>
							<div class="tab-content" id="contentTab-${rand}">
				  				<div class="tab-pane fade show active" id="graph-nutrientes-${rand}" role="tabpanel" aria-labelledby="graph-nutrientes-${rand}-tab">
				  					<div id="chart${rand}" class="content-graph"></div>
				  				</div>
				  				<div class="tab-pane fade" id="list-ingredientes-${rand}" role="tabpanel" aria-labelledby="list-ingredientes-${rand}-tab">
				  					<div class="list-ingredientes">
					  					<ul>
					  					<c:forEach items="${receta.recipe.ingredientLines}" var="ingrediente">
					  						<li><c:out value="${ingrediente}"></c:out></li>	
					  					</c:forEach>
						  				</ul>
				  					</div>
				  				</div>
							</div>
							<div class="receta-opt">
								<div class="calorias">
									<p>Calorías: <span id="caloriasReceta">${receta.recipe.calories / receta.recipe.yield}</span> kcal</p>
									<script>
										var caloriasReceta = document.getElementById('caloriasReceta');
										caloriasReceta.innerHTML = Math.round(caloriasReceta.innerHTML * 100) / 100;
										caloriasReceta.removeAttribute("id");
									</script>
								</div>
								<form action="VideosController" method="get">
									<input type="hidden" name="q" value="${receta.recipe.label}">
									<button class="btn btn-primary" type="submit">Vídeos</button>
								</form>
							</div>
						</div>
					</div>
				</div>
				<% i = i - 1; } else { i = 2; } %>
				
				<!-- Javascript para generar la gráfica de nutrientes -->	
				<input name="${rand}" value="<c:out value="${receta.recipe.totalNutrients.CHOCDF.quantity / receta.recipe.yield}" />" type="hidden"/>
				<input name="${rand}" value="<c:out value="${receta.recipe.totalNutrients.SUGAR.quantity / receta.recipe.yield}" />" type="hidden"/>
				<input name="${rand}" value="<c:out value="${receta.recipe.totalNutrients.FAT.quantity / receta.recipe.yield}" />" type="hidden"/>
				<input name="${rand}" value="<c:out value="${receta.recipe.totalNutrients.FIBTG.quantity / receta.recipe.yield}" />" type="hidden"/>
				<input name="${rand}" value="<c:out value="${receta.recipe.totalNutrients.PROCNT.quantity / receta.recipe.yield}" />" type="hidden"/>
				<script>
					var selector = '#chart'+<%=id %>;
					var nutrientes = document.getElementsByName('<%=id %>');
					var carbs = Math.round(nutrientes[0].value * 100) / 100;
					var sugar = Math.round(nutrientes[1].value * 100) / 100;
					var fat = Math.round(nutrientes[2].value * 100) / 100;
					var fiber = Math.round(nutrientes[3].value * 100) / 100;
					var protein = Math.round(nutrientes[4].value * 100) / 100;
					
					var graph = c3.generate({
						bindto: selector,
						data: {
							x: 'x',
							columns: [
								['Nutrientes', carbs, sugar, fat, fiber, protein],
								['x','Carbohidratos','Azúcares','Grasas','Fibra','Proteinas']
							]
						},
						axis: {
							x: {
								type: 'category',
								label: 'Nutrientes'
							},
							y: {
								label: 'Cantidad (g)'
							}
						},
						legend: {
							show: false
						}
					});	
				</script>
				<!-- fin Javascript de gráfica -->
			</c:forEach>
		</div><!-- fin .row (módulos recetas) -->
	</div><!-- fin .container -->
<%@ include file="includes/footer.jsp" %>