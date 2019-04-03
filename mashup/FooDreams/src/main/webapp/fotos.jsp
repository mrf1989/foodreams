<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="aiss.model.flickr.FotoSearch" %>
 <%@ page import="aiss.model.flickr.Photo" %>
 <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Fotos:</h2>
	<c:forEach items="${fotos}" var="foto">
		<img src="https://farm${foto.farm}.staticflickr.com/${foto.server}/${foto.id}_${foto.secret}.jpg" />
	</c:forEach>
	<p><a href="/">Volver</a></p>
</body>
</html>