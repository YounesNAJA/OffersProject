<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/main.css" />
</head>
<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>
	<c:if test="${param.error != null }">
		<p class="error">Username or password is incorrect.</p>
	</c:if>

	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>
		<table>
			<tr>
				<td class="label"><label for="username">User: </label></td>
				<td><input type='text' name='username' id='username' value=''></td>
			</tr>
			<tr>
				<td class="label"><label for="password">Password: </label></td>
				<td><input type='password' name='password' id='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<a href="<c:url value='/newuser'/>">Create a new account</a>
</body>
</html>