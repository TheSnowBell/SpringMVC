<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pageTemplate bodyClass="" title="Cadastro">
	<form:form action="${spring:mvcUrl('PC#cadastrar').build()}"
		method="post" commandName="produto" enctype="multipart/form-data">

		<div>
			<label for="titulo"><spring:message code="titulo" /></label>
			<form:input path="titulo" />
			<form:errors path="titulo" />
		</div>

		<div>
			<label for="descricao"> <spring:message code="descricao" /></label>
			<form:textarea path="descricao" rows="10" cols="20" />
			<form:errors path="descricao" />
		</div>
		<div>
			<label for="paginas"> <spring:message code="paginas" /></label>
			<form:input path="paginas" />
			<form:errors path="paginas" />
		</div>

		<div>
			<label for="dataLancamento"> <spring:message
					code="dataLancamento" /></label> <input type="date" name="dataLancamento" />
			<form:errors path="dataLancamento" />
		</div>

		<c:forEach items="${types}" var="bookType" varStatus="status">
			<div>
				<label for="preco_${bookType}">${bookType}</label>
				<form:input path="precos[${status.index}].valor" />
				<form:hidden path="precos[${status.index}].bookType"
					value="${bookType}" />
			</div>
		</c:forEach>

		<div>
			<label for="summary"> <spring:message code="summary" /></label> <input
				type="file" name="summary" />
			<form:errors path="summaryPath" />
		</div>

		<div>
			<spring:message code="formulario.submit" var="submit" />
			<input type="submit" value="${submit}" />
		</div>

	</form:form>
</customTags:pageTemplate>