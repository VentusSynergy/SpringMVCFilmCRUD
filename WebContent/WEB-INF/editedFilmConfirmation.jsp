<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Edited Film Confirmation</title>

</head>


<body>



	<c:choose>
		<c:when test="${! empty editedFilm}">
			<!-- need to add rest of attributes here -->
			<strong>Film ID: </strong>${film.id }<br>
				<strong>Film Title: </strong>${film.title}<br>
				<strong>Film Description: </strong>${film.description}<br>
				<strong>Release Year: </strong>${film.releaseYear}<br>
				<strong>Language: </strong>${film.languageId}<br>
				<strong>Length: </strong>${film.length}<br>
				<strong>Rating: </strong>${film.rating}<br>
				<strong>Actors: </strong>${film.actors}<br>


		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>

	<a href="index.html">Go home</a>
	<br />

</body>
</html>


