<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>fooDreams - Videos</title>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>
	<div class="container">
		<div class="row my-3">
			<div class="col-md-12">
				<h2>Resultados sobre: "<c:out value="${param.q}"/>"</h2>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${requestScope.videos}" var="video">
				<div class="col-md-6 col-sm-12">
					<div class="card video-module">
						<div class="card-body">
							<div class="embed-responsive embed-responsive-16by9">
								<iframe class="embed-responsive-item" width="500" height="315" src="https://www.youtube.com/embed/<c:out value="${video.id.videoId}" />" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe><br>
							</div>
							<form method="post" action="CONTROLADOR">
								<div class="form-row">
	                                <div class="form-group col-md-8 col-sm-8">
	                                    <select name="playlist" class="form-control">
	                                    	<option value="">-Selecciona una playlist-</option>
	                                    <c:forEach items="${requestScope.playlists}" var="playlist">
							                <option value="${playlist.id}"><c:out value="${playlist.snippet.title}"></c:out></option>	                                    	
	                                    </c:forEach>
					                	</select>
	                               	</div>
	                                <div class="form-group col-md-4 col-sm-4">
	                                    <button class="btn btn-primary btn-block" type="submit">
	                                        <i class="fas fa-plus"></i> <span class="btn-search-text">Añadir</span>
	                                   	</button>
	                                </div>
                                </div>
				        	</form>
				        </div>
					</div>        
				</div>     
			</c:forEach>
		</div>
	</div>
<%@ include file="includes/footer.jsp" %>