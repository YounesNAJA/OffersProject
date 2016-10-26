<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create user</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/main.css" />
</head>
<body>
	<f:form action="${pageContext.request.contextPath}/createuser"
		commandName="user" method="POST">
		<table>
			<tr>
				<td class="label"><label for="username">Username: </label></td>
				<td><f:input path="username" class="inputs" id="username"
						type="text" name="username" /> <f:errors path="username"
						cssClass="error"></f:errors><br /></td>
			</tr>
			<tr>
				<td class="label"><label for="email">Email: </label></td>
				<td><f:input path="email" class="inputs" id="email" type="text"
						name="email" /> <f:errors path="email" cssClass="error"></f:errors><br /></td>
			</tr>
			<tr>
				<td class="label"><label for="password">Password: </label></td>
				<td><f:input path="password" class="inputs" id="password"
						type="password" name="password" /> <f:errors path="password"
						cssClass="error"></f:errors><br /></td>
			</tr>
			<tr>
				<td class="label"><label for="confirmpassword">Confirm
						Password: </label></td>
				<td><input class="inputs" id="confirmpassword" type="password"
					name="confirmpassword" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</f:form>
</body>
</html>