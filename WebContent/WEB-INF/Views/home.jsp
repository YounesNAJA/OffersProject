<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<p>
		<a href="<c:url value='/offers' />">Show current offers.</a>
	</p>
	<p>
		<a href="<c:url value='/createoffer' />">Add a new offers.</a>
	</p>
	<sec:authorize access="hasAuthority('admin')">
		<p>
			<a href="<c:url value='/admin' />">Access to admin page.</a>
		</p>
	</sec:authorize>
	<div>
		<!-- <c:url var="logoutUrl" value="/logout" /> -->

		<sec:authorize access="isAuthenticated()">
			<form action="${logoutUrl}" method="post">
				<input type="submit" value="Logout" /> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</sec:authorize>
	</div>



</body>
</html>