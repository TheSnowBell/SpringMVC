<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${sucesso}
	<table>
		<tr>
			<td>Titulo</td>
			<td>Valores</td>
		</tr>
		<c:forEach items="${produtos}" var="produto">
			<tr>
				<td>${produto.titulo}</td>
				
				<td>
					<c:forEach items="${produto.precos}" var="preco">
						[${preco.valor} - ${preco.bookType}]
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>