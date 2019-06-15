<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Employee</h1>
		<form method="post" action="/springmvcproject/save">
		<table >  
         <tr>  
          <td>Name : </td> 
          <td><input type="text" name="name"/></td>
         </tr>  
         <tr>  
          <td>Salary :</td>  
          <td><input type="text" name="salary"/></td>
         </tr> 
         <tr>  
          <td>Designation :</td>  
          <td><input type="text" name="designation"/></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save"/></td>  
         </tr>  
        </table>  
		</form>
      
