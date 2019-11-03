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
<title>Search by Keyword</title>
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/webjars/org.webjars/bootstrap/4.3.1/css/bootstrap.css"
	rel="stylesheet">
</head>
<body>

	<div>
		<p>
			<em><strong>Film Results by Keyword</strong></em>
		</p>
		<div>
			<%-- 			<form action="keyword.do" method="GET">
				<input type="text" name="keyword" /> <input type="submit"
					value="Search" /> --%>

			<form action="keyword.do" method="GET">
				<input type="text" name="keyword" placeholder="seach keyword" /> <input class="btn btn-primary"
					type="submit" value="Search" />
			</form>
			<br>
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
							<li><strong>Category: </strong>${film.category}</li>
						</ul>
					</c:forEach>

					<%-- <p><strong>Film List by Keyword:</strong>${filmList}</p> --%>
				</c:when>
				<c:otherwise>
					<p>No film found</p>
				</c:otherwise>
			</c:choose>
			</form>
		</div>
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