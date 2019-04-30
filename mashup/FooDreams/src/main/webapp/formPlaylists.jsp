<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>Crear nueva playlist fooDreams</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form action="NewPlaylistController" method="GET">
					<div class="form-group">
						<label for="titulo">Título</label>
						<input id="titulo" class="form-control" type="text" name="titulo" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="descripcion">Descripción</label>
						<textarea id="descripcion" class="form-control" name="descripcion"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Crear playlist</button>
				</form>
			</div>
		</div>
	</div>
<%@ include file="includes/footer.jsp" %>