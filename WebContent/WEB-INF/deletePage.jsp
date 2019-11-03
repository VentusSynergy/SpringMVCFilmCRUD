<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Delete Film</title>

</head>


<body>



	<c:choose>

		<c:when test="${! empty list}">
			<!-- need to add rest of attributes here -->
				
				<p><strong>Film Title: </strong>${list}</p>


		</c:when>
		<c:otherwise>
			<p>Empty List</p>
		</c:otherwise>
	</c:choose>
	<form action="deleteFilm.do" method="POST">
		Enter Film ID: <input type="text" name="filmId" /> <input type="submit"
			value="Delete Film" />
	</form>

	
	<form action="editFilmPage.do" method="POST">
		Enter Film ID: <input type="text" name="filmId" /> 
		<input type="submit" value="Edit Film" />
	</form>
	
	<br>
	<form action="index.html" method="POST">
		<input type="submit" value="Home Page" />
	</form>

</body>
</html>