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
							<div class="mb-2 embed-responsive embed-responsive-16by9">
								<iframe class="embed-responsive-item" width="500" height="315" src="https://www.youtube.com/embed/videoseries?list=<c:out value="${playlist.id}" />" frameborder="0" allowfullscreen></iframe>
							</div>
							<div class="row">
								<div class="col-md-12">
									<h4 id="titlePlaylist" class="card-title playlistTitle"><c:out value="${playlist.snippet.title}" /></h4>
									<script>
										var titlePlaylist = document.getElementById("titlePlaylist");
										titlePlaylist.innerHTML = titlePlaylist.innerHTML.replace("fooDreams - ", "");
										titlePlaylist.removeAttribute("id");
									</script>
								</div>
							</div>	
							<div class="row">
								<div class="card-text col-md-12"><c:out value="${playlist.snippet.description}" /></div>
							</div>
							<div class="mt-2 row">
								<div class="col-md-12 d-flex justify-content-between">
									<form action="UpdatePlaylistController" method="GET">
										<input type="hidden" name="id" value="<c:out value="${playlist.id}" />" />
										<button type="submit" class="btn btn-secondary"><i class="fas fa-edit"></i> Editar</button>
									</form>
									<form action="DeletePlaylistController" method="GET">
										<input type="hidden" name="playlistId" value="<c:out value="${playlist.id}" />" />
										<button type="submit" class="btn btn-danger"><i class="fas fa-trash-alt"></i> Eliminar</button>
									</form>
								</div>
							</div>
				        </div>
					</div>        
				</div>     
			</c:forEach>
		</div>
	</div>
<%@ include file="includes/footer.jsp" %>