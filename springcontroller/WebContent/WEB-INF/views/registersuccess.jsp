<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>userName</td>
<td>${user.name}</td>
</tr>
<tr>
<td>Email</td>
<td>${user.email }</td>
</tr>
<tr>
<td>Age</td>
<td>${user.age}</td>
</tr>
<tr>
<td>Country</td>
<td>${user.country}</td>
</tr>
</table>
<a href="http://localhost:8080/springmvc1/register">Back</a>
</body>
</html>