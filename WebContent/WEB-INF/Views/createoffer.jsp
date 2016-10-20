<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Offer</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/main.css">
</head>
<body>
	<f:form action="${pageContext.request.contextPath}/docreate"
		commandName="offer" method="POST">
		<table>
			<tr>
				<td class="label"><label for="name">Name: </label></td>
				<td><f:input path="name" class="inputs" id="name" type="text"
						name="name" /><f:errors path="name" cssClass="error"></f:errors><br /></td>
			</tr>
			<tr>
				<td class="label"><label for="email">Email: </label></td>
				<td><f:input path="email" class="inputs" id="email" type="text"
						name="email" /><f:errors path="email" cssClass="error"></f:errors><br /></td>
			</tr>
			<tr>
				<td class="label"><label for="text">Text: </label></td>
				<td><f:textarea path="text" class="inputs" id="text"
						name="text" col="10" row="10"></f:textarea><f:errors path="text" cssClass="error"></f:errors><br /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</f:form>


</body>
</html>