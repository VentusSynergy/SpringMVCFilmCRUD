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
	<form:form action="createFilm.do" method="POST">
		<div>
		<label for="createFilm.do">Create Film</label>
		<input type="text" name="title" placeholder="Add Film Title">
		</div>
	</form:form>
</body>
</html>