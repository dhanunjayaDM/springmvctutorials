<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" modelAttribute="applicationGeneralInformation">
  <div class="section2">
    <h2>General Informaion</h2>

    <form:input type="hidden" path="id" id="id"/>
    <label for="app_version">Version</label>: <form:input type="text" id="app_version" path="version"/><br/>
    <label for="app_func_desc">Description</label>: <form:input type="text" id="app_func_desc"
                                                                       path="functionalDescription"/><br/>
   <label for="app_sec_func">Functions</label>: <form:input type="text" id="app_sec_func"
                                                                  path="securityFunctions"/><br/>

</div>
<div class="section2">
  <h2>Application Content</h2>
  <form:form method="POST" modelAttribute="applicationContent">
    <div>
        <h3>CIA Rating</h3>
        <label for="CIARating">CIA Rating</label>: <form:select type="text" id="CIARating" path="CIARating">
        <form:option value="1">1</form:option>
        <form:option value="2">2</form:option>
        <form:option value="3">3</form:option>
        <form:option value="4">4</form:option>
    </form:select><br/><br/>
    </div>
    <div>
        <h3>Business Continuity and Disaster Recovery</h3>
        <div>
            <h4>RTO</h4>
            <label for="RTO">RTO</label>: <form:select type="text" id="RTO" path="RTO">
            <form:option value="1">< 2<sub>Hrs</sub></form:option>
            <form:option value="2">2<sub>Hrs</sub>-4<sub>Hrs</sub>    </form:option>
            <form:option value="3">4<sub>Hrs</sub>-48<sub>Hrs</sub></form:option>
            <form:option value="4">> 48<sub>Hrs</sub></form:option>
        </form:select><br/>
        </div>
        <div>
            <h4>RPO</h4>
            <label for="RPO">RPO</label>: <form:input type="text" id="RPO" path="RPO"/><br/>
        </div>
    </div>
  </form:form>
  <input type="submit" value="Submit">
 </div>
 </form:form>
</body>
</html> --%>