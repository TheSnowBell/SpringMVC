<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pageTemplate bodyClass="" title="Login">
	<form:form servletRelativeAction="/login">

		<div>
			<label> <spring:message code="login" /> <input type='text'
				name='username'>
			</label>
		</div>
		<div>
			<label> <spring:message code="password" /> <input
				type='password' name='password' />
			</label>
		</div>
		<div>
			<spring:message code="auth.submit" var="submit" />
			<input name="submit" type="submit" value="${submit}" />
		</div>

	</form:form>

</customTags:pageTemplate>