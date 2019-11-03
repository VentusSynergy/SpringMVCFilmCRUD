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
		<c:when test="${! empty editedFilm}"> <!-- need to add rest of attributes here -->
			<form action="editFilm.do" method="POST">
			Movie Title:
			<input type="text" name="title" value="${film.title}" /><br>
			Description:
			<input type="text" name="description" value="${film.description}" /><br>
			Release Year:
			<input type="text" name="releaseYear" value="${film.releaseYear}" /><br>
			Language ID (1 is English):
			<input type="text" name="languageId" value="${film.languageId}" /><br>
			Rental Duration:
			<input type="text" name="rentalDuration" value="${film.rentalDuration}" /><br>
			Rental Rate:
			<input type="text" name="rentalRate" value="${film.rentalRate}" /><br>
			Length:
			<input type="text" name="length" value="${film.length}" /><br>
			Replacement Cost:
			<input type="text" name="replacementCost" value="${film.replacementCost}" /><br>
			Rating(G or PG):
			<input type="text" name="rating" value="${film.rating}" /><br>
	
			<!-- <input type="submit" value="Update Film" /> -->
			</form>


		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
	
	<a href="index.html">Go home</a><br/>
	
</body>
</html>


