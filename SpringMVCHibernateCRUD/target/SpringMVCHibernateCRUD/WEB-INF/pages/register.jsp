<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:form>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<springForm:form method="POST" modelAttribute="userRegistration" action="/SpringMVCHibernateCRUD/registersuccess">
		<table>
			<tr>
				<td>Name:</td>
				<td><springForm:input path="name" /></td>
				<%-- <td><springForm:errors path="name" cssClass="error" /></td> --%>
			</tr>
			<tr>
				<td>Email:</td>
				<td><springForm:input path="email" /></td>
				<%-- <td><springForm:errors path="email" cssClass="error" /></td> --%>
			</tr>
			<tr>
				<td>Password:</td>
				<td><springForm:input path="password" /></td>
				<%-- <td><springForm:errors path="password" cssClass="error" /></td> --%>
			</tr>
			<tr>
				<td>ConfirmPassword:</td>
				<td><springForm:input path="confirmpassword" /></td>
				<%-- <td><springForm:errors path="country" cssClass="error" /></td --%>>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Save Customer"></td>
			</tr>
		</table>

	</springForm:form>
</body>
</html:form>