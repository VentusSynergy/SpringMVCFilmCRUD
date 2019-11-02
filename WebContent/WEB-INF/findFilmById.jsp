<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Find Film By ID</title>
</head>
<body>
	<form:form action="findFilmById.do" method="GET">
		<%-- <form:label path="Id">Enter Film ID#:</form:label>
		<form:input path="Id" />
		<form:errors path="Id" />
		<input type="submit" value="Find"/> --%>
		<div>
			<label for="filmId">Film Id</label>
			<input type="text" name="id" placeholder="Film Id">
		</div>
	</form:form>
</body>
</html>