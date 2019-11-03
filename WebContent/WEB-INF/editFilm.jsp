<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Edit Film</title>

</head>


<body>

	<c:choose>
		<c:when test="${! empty film}">
			<!-- need to add rest of attributes here -->
			<ul>
				<li><strong>Film Title: </strong>${film.title}</li>
				<li><strong>Film Description: </strong>${film.description}</li>
				<li><strong>Release Year: </strong>${film.releaseYear}</li>
				<li><strong>Language: </strong>${film.language}</li>
				<li><strong>Length: </strong>${film.length}</li>
				<li><strong>Actors: </strong>${film.actors}</li>
			</ul>
			<div>
				<form:form action="editThisFilm.do" method="POST">
					<p>
						<label>Film Title:<input type="text"></label>
					</p>
					<p>
						<label>Description:<input type="text"></label>
					</p>
					<p>
						<label>Release Year:<input type="text"></label>
					</p>
					<p>
						<label>Language:<input type="text"></label>
					</p>
					<p>
						<label>Length:<input type="text"></label>
					</p>
					<!-- <p><label>Actors:<input type="text"></label></p> -->

					<%-- <form action="editThisFilm.do" method="POST"> --%>
						<input type="submit" value="Edit Film" />
					<%-- </form> --%>
				</form:form>
			</div>
		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>


</body>
</html>


