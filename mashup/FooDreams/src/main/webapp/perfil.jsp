<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>fooDreams - Mis playlists</title>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>
	<div class="container">
		<div class="row my-3">
			<div class="col-md-12 py-2 d-flex justify-content-center">
				<button class="btn btn-primary btn-lg" onclick="location.href='/formPlaylists.jsp'"><i class="fas fa-plus"></i> Nueva playlist</button>
			</div>
		</div>
		<div class="row my-3">
			<div class="col-md-12">
				<h2>Mis playlists</h2>
			</div>
		</div>
		<div class="row my-3">
			<c:forEach items="${requestScope.playlists}" var="playlist">
				<div class="col-md-6 col-sm-12">
					<div class="card video-module">
						<div class="card-body">
							<div class="embed-responsive embed-responsive-16by9">
								<iframe class="embed-responsive-item" width="500" height="315" src="https://www.youtube.com/embed/videoseries?list=<c:out value="${playlist.id}" />" frameborder="0" allowfullscreen></iframe>
							</div>
				        </div>
					</div>        
				</div>     
			</c:forEach>
		</div>
	</div>
<%@ include file="includes/footer.jsp" %>