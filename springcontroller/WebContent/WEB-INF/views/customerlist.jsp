<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<caption>List of Customers</caption>
<tr>
<th>Name</th>
<th>Email</th>
<th>Age</th>
<th>Country</th>
</tr>
<c:forEach var="customer" items="${customerlist}"> 
<tr>
<td><c:out value="${customer.name }"></c:out></td>
<td><c:out value="${customer.email }"></c:out></td>
<td><c:out value="${customer.age }"></c:out></td>
<td><c:out value="${customer.country }"></c:out></td>
</tr>
</c:forEach>

</table>
</body>
</html>