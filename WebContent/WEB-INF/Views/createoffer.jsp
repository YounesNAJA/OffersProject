<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Offer</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
</head>
<body>
	<form action="${pageContext.request.contextPath}/docreate"
		method="POST">
		<table>
			<tr>
				<td class="label"><label for="name">Name: </label></td>
				<td><input class="inputs" id="name" type="text" name="name" /></td>
			</tr>
			<tr>
				<td class="label"><label for="email">Email: </label></td>
				<td><input class="inputs" id="email" type="text" name="email" /></td>
			</tr>
			<tr>
				<td class="label"><label for="text">Text: </label></td>
				<td><textarea class="inputs" id="text" name="text" col="10" row="10" ></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>