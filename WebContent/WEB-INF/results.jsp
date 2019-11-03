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
<title>results</title>
<link
	href="https://cdn.jsdelivr.net/webjars/org.webjars/bootstrap/4.3.1/css/bootstrap.css"
	rel="stylesheet">
</head>


<body>


	<c:choose>
		<c:when test="${! empty film}">
			<!-- need to add rest of attributes here -->
			<ul>
				<li><strong>Film ID: </strong>${film.id }</li>
				<li><strong>Film Title: </strong>${film.title}</li>
				<li><strong>Film Description: </strong>${film.description}</li>
				<li><strong>Release Year: </strong>${film.releaseYear}</li>
				<li><strong>Language: </strong>${film.languageId}</li>
				<li><strong>Length: </strong>${film.length}</li>
				<li><strong>Actors: </strong>${film.actors}</li>
			</ul>


		</c:when>
		<c:otherwise>
			<p>Unable to add film</p>
		</c:otherwise>
	</c:choose>

	<form action="index.html" method="POST">
		<input type="submit" value="Home Page" />
	</form>
	<br>

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
