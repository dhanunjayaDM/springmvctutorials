<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/springcontroller/registersuccess", method="post" modelAttribute="user">
		<table>
			<tr>
				<td>userName:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>age:</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>country:</td>
				<td>
				    <select name="country">
						<option value="india">India</option>
						<option value="us">US</option>
						<option value="other">other</option>
				    </select>
				</td>
			</tr>
			<tr>
				<td>Submit</td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>