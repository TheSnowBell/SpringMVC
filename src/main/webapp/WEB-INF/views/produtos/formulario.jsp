<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de produtos</title>
</head>
<body>


	<form:form 	action="${spring:mvcUrl('PC#cadastrar').build()}" 
			 	method="post" 
			 	commandName="produto" 
			 	enctype="multipart/form-data">

		<div>
			<label for="titulo">Titulo</label>
			<form:input path="titulo" />
			<form:errors path="titulo" />
		</div>
		
		<div>
			<label for="descricao">Descrição</label>
			<form:textarea path="descricao" rows="10" cols="20"/>
			<form:errors path="descricao"/>
		</div>
		<div>
			<label for="paginas">Número de paginas</label> 
			<form:input path="paginas"/>
			<form:errors path="paginas"/>
		</div>

		<div>
			<label for="dataLancamento">Data de lançamento</label>
			<input type="date" name="dataLancamento"/>
			<form:errors path="dataLancamento"/>
		</div>

		<c:forEach items="${types}" var="bookType" varStatus="status">
			<div>
				<label for="preco_${bookType}">${bookType}</label> 
				<form:input path="precos[${status.index}].valor" />
				<form:hidden path="precos[${status.index}].bookType" value="${bookType}"/>
			</div>
		</c:forEach>

		<div>
			<label for="summary">Sumario do livro</label>
			<input type="file" name="summary"/>
			<form:errors path="summaryPath"/>
		</div>

		<div>
			<input type="submit" value="Enviar">
		</div>

	</form:form>
</body>
</html>