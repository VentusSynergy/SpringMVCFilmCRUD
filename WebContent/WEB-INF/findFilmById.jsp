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
<title>Film Results</title>
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/webjars/org.webjars/bootstrap/4.3.1/css/bootstrap.css"
	rel="stylesheet">
</head>
<br>
<body>
	<div>
		<form action="findFilmById.do" method="GET">
			<input type="text" name="filmId" placeholder="enter film ID"/> <input type="submit"
				class="btn-primary" value="Search" />
		</form>
		<br>
		<p>
			<em><strong>Film Results by ID</strong></em>
		</p>
	</div>
	<br>
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
		<br> <a href="index.html">HOME</a>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://cdn.jsdelivr.net/webjars/org.webjars.bower/jquery/3.3.1/dist/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://cdn.jsdelivr.net/webjars/org.webjars/popper.js/1.15.0/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/webjars/org.webjars/bootstrap/4.3.1/js/bootstrap.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap-4.3.1.js"></script>
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
