<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>fooDreams - ERROR</title>
<%@ include file="includes/head.jsp" %>
	<div class="jumbotron jumbotron-fluid">
  		<div class="container">
    		<h1 class="display-4">Error!</h1>
    		<p class="lead">¿Se quema la comida? Algo ha pasado, no sabemos 'croquétamente' qué...</p>
  		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="alert alert-danger" role="alert">
  					¡Se ha producido un error!
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
			<c:if test="${not empty error}">
				<div class="content-error">
					<p style="color:red"><c:out value="${error}" /></p>
				</div>
			</c:if>
				<p>Te recomendamos que regreses a la <a href="/">página de inicio</a> y vuelvas a realizar una búsqueda.</p>
				<p>En caso de que el problema persista, reinicia la sesión de tu navegador web.</p>
				<p>¡Sentimos las molestias! Y recuerda que, <em>con frío o con calor...come coliflor!</em></p>
			</div>
		</div>
	</div>
</body>
</html>