<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil usuario - Playlists</title>
</head>
<body>
	<h1>Resultados</h1>
	<c:forEach items="${requestScope.playlists}" var="playlist">
		<span>${playlist.snippet.title}</span><br>
	</c:forEach>
	<a href="/">Volver</a>
</body>
</html>