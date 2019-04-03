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
		<span>${video.item.snippet.title}</span><br>
		<form action="VideosController" method="get">
			<input type="hidden" name="q" value="${video.item.snippet.title}">
		</form>
	</c:forEach>

</body>
</html>