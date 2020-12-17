<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pageTemplate bodyClass="" title="Login">
	<form:form servletRelativeAction="/login">

		<div>
			<label> User <input type='text' name='username' value=''>
			</label>
		</div>
		<div>
			<label>Password <input type='password' name='password' />
			</label>
		</div>
		<div>
			<input name="submit" type="submit" value="Login" />
		</div>

	</form:form>

</customTags:pageTemplate>