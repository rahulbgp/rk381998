<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  <%@ page isELIgnored="false"%>
  
  <h1>Customer List</h1>  
<table border="3" width="20%">  
<tr><th>Id</th><th>Name</th><th>Email</th><th>Age</th><th>Delete::</th></tr>  
  <!-- emps === model attribute in controller -->
   <c:forEach var="emp11" items="${emps}">   
   <tr>  
   <td>${emp11.id}</td>  
   <td>${emp11.name}</td>  
   <td>${emp11.email}</td>      
   <td>${emp11.age}</td>      
        <td>
        <!-- 1.onclick javascript event 2.confirm similar to alert but takes OK CANCEL BUTTONS -->
       <a href="deleteemps/${emp11.id}" onclick="if(!(confirm('Are you sure you want to delete this employee?'))) return false">DeleteRecord</a></td>      
   
   </tr>  
   </c:forEach>  
   </table>
