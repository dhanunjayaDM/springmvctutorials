<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Citizen Registration</title>

    </head>
    <body>                     
            <div id="tab2">
                <form:form method="post" modelAttribute="employer" action="relationalProcess" accept-charset="ISO-8859-1">
                <ol>
                    <li>
                        <form:label for ="ename" path="ename">Name</form:label>
                        <form:input path="ename" id="ename"/>                   
                    </li>
                    <li>
                   <form:select  path="employee.id">
				        <form:option value="0" label="select drug name" />
				        <form:options items="${listEmployee}" itemLabel="name" itemValue="id"/>
					</form:select>
                    </li>
                    <li>                          
					<input type="submit" value="save"/>
					</li>
				 </ol>       
                </form:form>            
            </div>                      
    </body>
</html>