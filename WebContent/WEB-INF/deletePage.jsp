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
<title>Delete Film</title>
<link
	href="https://cdn.jsdelivr.net/webjars/org.webjars/bootstrap/4.3.1/css/bootstrap.css"
	rel="stylesheet">
</head>


<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> &nbsp;
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon" id="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="index.html">Home <span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Menu </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="userStories.html">User Stories</a> <a
						class="dropdown-item"
						href="https://github.com/VentusSynergy/SpringMVCFilmCRUD/blob/master/README.md">ReadMe</a>


				</div></li>

		</ul>
	</div>
	</nav>


	<c:choose>

		<c:when test="${! empty list}">
			<!-- need to add rest of attributes here -->

			<p>
				<strong>Film Title: </strong>${list}</p>


		</c:when>
		<c:otherwise>
			<p>Empty List</p>
		</c:otherwise>
	</c:choose>
	<form action="deleteFilm.do" method="POST">
		Enter Film ID: <input type="text" name="filmId" required="required" />
		<input class="btn btn-danger" type="submit" value="Delete Film" />
	</form>
	<hr>
	<form action="editFilmPage.do" method="POST">
		Enter Film ID: <input type="text" name="filmId" required="required" />
		<input class="btn btn-warning" type="submit" value="  Edit Film  " />
	</form>
	<hr>
	<br>
	<footer class="text-center">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<p>Copyright © MyWebsite. All rights reserved.</p>
			</div>
		</div>
	</div>
	</footer>
	<%-- 	<form action="index.html" method="POST">
		<input type="submit" value="Home Page" />
	</form> --%>
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