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
	<form:form action="createFilm.do" method="POST" modelAttribute="user">
		<form:label path="email">Email:</form:label>
		<form:input path="email" />
		<form:errors path="email" />
		<br />
		<form:label path="password">Password:</form:label>
		<form:input path="password" />
		<form:errors path="password" />
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>