<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form:form action="findFilmById.do" method="GET" modelAttribute="user">
		<form:label path="id">Enter Film ID#:</form:label>
		<form:input path="id" />
		<form:errors path="id" />
		<input type="submit" value="Find"/>

	</form:form>
</body>
</html>