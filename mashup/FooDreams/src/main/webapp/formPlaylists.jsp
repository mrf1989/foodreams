<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<% String controller = "NewPlaylistController"; %>
<% String pageTitle = "Nueva playlist"; %>
<% String btnVal = "Crear playlist"; %>
<% String metodo = "GET"; %>
<c:if test="${not empty playlist}">
	<% controller = "UpdatePlaylistController"; %>
	<% pageTitle = "Editar playlist"; %>
	<% btnVal = "Guardar"; %>
	<% metodo = "POST"; %>
</c:if>
<title>fooDreams - <%= pageTitle %></title>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>
	<div class="container">
		<div class="row my-3">
			<div class="col-md-6 offset-md-3">
				<h2><%= pageTitle %></h2>
			</div>
		</div>
		<div class="row my-3">
			<div class="col-md-6 offset-md-3">
				<form action="<%= controller %>" method="<%= metodo %>">
					<div class="form-group">
						<label for="titulo">Título</label>
						<input id="titulo" class="form-control" type="text" name="titulo" value="${playlist.snippet.title}" autocomplete="off">
						<script>
							var titulo = document.getElementById("titulo");
							if (titulo != "") {
								titulo.value = titulo.value.replace("fooDreams - ", "");
							}
						</script>
					</div>
					<div class="form-group">
						<label for="descripcion">Descripción</label>
						<textarea id="descripcion" class="form-control" name="descripcion"><c:out value="${playlist.snippet.description}" /></textarea>
					</div>
				<c:if test="${not empty playlist}">
					<input type="hidden" name="playlistId" value="${playlist.id}" />
				</c:if>
					<button type="submit" class="btn btn-primary"><i class="fas fa-utensils"></i> <%= btnVal %></button>
				</form>
			</div>
		</div>
	</div>
<%@ include file="includes/footer.jsp" %>