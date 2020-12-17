<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pageTemplate bodyClass="" title="Listar">

	${sucesso}
	<security:authorize access="isAuthenticated()">
		<security:authentication property="principal" var="user" />
		<div>Olá ${user.nome}</div>
	</security:authorize>
	<table>
		<tr>
			<td>Titulo</td>
			<td>Valores</td>
		</tr>
		<c:forEach items="${produtos}" var="produto">
			<tr>

				<td><a
					href="${spring:mvcUrl('PC#show').arg(0,produto.id).build()}">
						${produto.titulo} </a></td>

				<td><c:forEach items="${produto.precos}" var="preco">
						[${preco.valor} - ${preco.bookType}]
					</c:forEach></td>
			</tr>
		</c:forEach>
	</table>
</customTags:pageTemplate>