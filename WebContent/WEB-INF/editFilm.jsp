<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit Film</title>
<link
	href="https://cdn.jsdelivr.net/webjars/org.webjars/bootstrap/4.3.1/css/bootstrap.css"
	rel="stylesheet">

</head>


<body>



	<c:choose>

		<c:when test="${! empty film}">
			<!-- need to add rest of attributes here -->
			<form action="editFilm.do" method="POST">
				<input type="hidden" name="id" value="${film.id}" /><br> ID:
				${film.id}<br> Movie Title: <input type="text" name="title"
					value="${film.title}" /><br> Description: <input type="text"
					name="description" value="${film.description}" /><br> Release
				Year: <input type="text" name="releaseYear"
					value="${film.releaseYear}" /><br>Language: <select
					name="languageId">
					<option value="1">English</option>
					<option value="2">Italian</option>
					<option value="3">Japanese</option>
					<option value="4">Mandarin</option>
					<option value="5">French</option>
					<option value="6">German</option>
					<br>
				</select><br> Rental Duration: <input type="text" name="rentalDuration"
					value="${film.rentalDuration}" /><br> Rental Rate: <input
					type="text" name="rentalRate" value="${film.rentalRate}" /><br>
				Length: <input type="text" name="length" value="${film.length}" /><br>
				Replacement Cost: <input type="text" name="replacementCost"
					value="${film.replacementCost}" /><br> Rating: <select
					name="rating">
					<option value="G">G</option>
					<option value="PG">PG</option>
					<option value="PG13">PG13</option>
					<option value="R">R</option>
					<option value="NC17">NC17</option>
				</select> <br> <input type="submit" value="Update Film" />
			</form>

		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
	<br>
	<form action="index.html" method="POST">
		<input type="submit" value="Home Page" />
	</form>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://cdn.jsdelivr.net/webjars/org.webjars.bower/jquery/3.3.1/dist/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://cdn.jsdelivr.net/webjars/org.webjars/popper.js/1.15.0/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/webjars/org.webjars/bootstrap/4.3.1/js/bootstrap.js"></script>

</body>
</html>


