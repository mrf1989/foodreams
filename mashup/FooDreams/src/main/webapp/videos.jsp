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
		<h1>Resultados de videos para: <c:out value="${param.q}"/></h1>
		<div class="row">
			<c:forEach items="${requestScope.videos}" var="video">
				<div class="col-md-6 col-sm-12">
					<div class="card video-module">
						<div class="card-body">
							<iframe width="500" height="315" src="https://www.youtube.com/embed/<c:out value="${video.id.videoId}" />" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe><br>
							<form method="post" action="CONTROLADOR">
								<div class="form-row">
	                                <div class="form-group col-md-8 col-sm-8">
	                                    <select name="playlist" class="form-control">
							                <option value="playlist">Foodreams: macarrones</option>
											<option value="playlist">Foodreams: pollo en salsa</option>
											<option value="playlist">Foodreams: ensalada </option>
											<option value="playlist">Foodreams: arroz</option>
					                	</select>
	                               	</div>
	                                <div class="form-group col-md-4 col-sm-4">
	                                    <button class="btn btn-primary btn-block" type="submit">
	                                        <i class="fas fa-plus"></i> <span class="btn-search-text">a�adir</span>
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