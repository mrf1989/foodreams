<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Resultados de videos para: <c:out value="${param.q}"/></h1>
	<c:forEach items="${requestScope.videos}" var="video">
		<span>${video.snippet.title}</span><br>
		<iframe width="560" height="315" src="https://www.youtube.com/embed/<c:out value="${video.id.videoId}" />" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe><br>
	</c:forEach>
	
	
	
</body>
</html>