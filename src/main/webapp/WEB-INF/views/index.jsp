<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<form action="produtos/formulario">

		<div>
			<spring:message code="formulario.submit" var="submit" />
			<input type="submit" value="${submit}">
		</div>

	</form>

</body>
</html>