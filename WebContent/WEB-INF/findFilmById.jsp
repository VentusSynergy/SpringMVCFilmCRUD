<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film Results</title>
</head>
<body>
	<div>
		<form action="findFilmById.do" method="GET">
			<input type="text" name="filmId" /> <input type="submit"
				value="Find Film" />
		</form>
			<p>
			<em><strong>Film Results by ID</strong></em>
		</p>
	</div>
	<div>
		<c:choose>
			<c:when test="${! empty film}">
				<!-- need to add rest of attributes here -->
				<strong>Film Title: </strong>${film.title}<br>
				<strong>Film Description: </strong>${film.description}<br>
				<strong>Release Year: </strong>${film.releaseYear}<br>
				<strong>Language: </strong>${film.language}<br>
				<strong>Length: </strong>${film.length}<br>
				<strong>Rating: </strong>${film.rating}<br>
				<strong>Actors: </strong>${film.actors}<br>
				<strong>Category: </strong>${film.category}<br>


			</c:when>
			<c:otherwise>
				<p>No film found, enter film ID</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>

<%-- <body>
	<form:form action="findFilmById.do" method="GET">
		<form:label path="Id">Enter Film ID:</form:label>
		<form:input path="Id" />
		<form:errors path="Id" />
		
		<input type="submit" value="Find"/>

=======
	<form:form action="findFilmById.do" method="GET">
		<%-- <form:label path="Id">Enter Film ID#:</form:label>
		<form:input path="Id" />
		<form:errors path="Id" />
		<input type="submit" value="Find"/> --%>
<!-- <div>
			<label for="filmId">Film Id</label>
			<input type="text" name="id" placeholder="Film Id">
		</div> -->
<%-- </form:form>
	
	
	<form action="findFilmById.do" method="GET">
		<input type="submit" value="Find Film" />
	</form>
	<form action="createFilm.do" method="GET">
		<input type="submit" value="Creat Film" />
	</form>
	
	
</body> --%>
