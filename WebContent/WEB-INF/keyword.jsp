<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search by Keyword</title>
</head>
<body>
	<div>
		<p>
			<em><strong>Film Results by Keyword</strong></em>
		</p>
		<c:choose>
			<c:when test="${! empty filmList}">
				<!-- need to add rest of attributes here -->
				<c:forEach items="${filmList}" var="film">
					<ul>
						<li><strong>Film Id: </strong>${film.id}</li>
						<li><strong>Film Title: </strong>${film.title}</li>
						<li><strong>Film Description: </strong>${film.description}</li>
						<li><strong>Release Year: </strong>${film.releaseYear}</li>
						<li><strong>Language: </strong>${film.language}</li>
						<li><strong>Length: </strong>${film.length}</li>
						<li><strong>Actors: </strong>${film.actors}</li>
					</ul>
				</c:forEach>

				<%-- <p><strong>Film List by Keyword:</strong>${filmList}</p> --%>
			</c:when>
			<c:otherwise>
				<p>No film found</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>