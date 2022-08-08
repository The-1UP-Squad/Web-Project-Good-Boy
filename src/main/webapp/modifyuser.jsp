<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <link rel="stylesheet" href="./CSS/stylesheet.css">
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <link rel="stylesheet" href="./CSS/highcontrast.css">
    <script src="homepage.js"></script>
    <title>Project Planner Application - Add User</title>
  </head>

<h1><img src="logo.png"><p style="color:#000048; p style=font-family:"arial";> New User Form  </h1>

   <div class="Logout">
   <a class="button button2" href="login.jsp"> Log Out </a>
   </div>
   
        <div class="highcontrast">
   <a class="button button2" href='javascript:void(0);' onclick='retheme()' title='Change Theme'>High Contrast</a>
   </div>

  <nav>
      <div class="menu">
        <ul>
          <li><a href="UserControllerServlet">Home</a></li>
          <li><a href="${addUserLink}">Users</a></li>
          <li><a href="addproject.jsp">Projects</a></li>
        </ul>
      </div>
  </nav>
  
  <br>
  
    
  <div class="formUser">
  <form action="UserControllerServlet" method="GET">
<input type="hidden" name="command" value="UPDATE"/>
<input type="hidden" name="employeeId" value="${ THE_EMPLOYEE.id}"/>
      
	  
	  
      <label for="fName"><b>First Name:</b>&ensp;&nbsp;&nbsp; </label>
      <input type="text" id="fName" name="fName" value=${THE_EMPLOYEE.fName }><br><br>
      
      <label for="lName"><b>Last Name:</b>&emsp;&emsp;&emsp;&nbsp;</label>
      <input type="text" id="lName" name="lName" value=${THE_EMPLOYEE.lName }><br><br>
      
      <label for="email"><b>Email:</b></label>
      <input type="email" id="email" name="email" value=${THE_EMPLOYEE.email }><br><br>
      
      
      
      <label for="other"><b>Other:</b>&emsp;&emsp;&emsp;&nbsp;</label>
      <input type="text" id="other" name="other"><br><br><br><br>
      <button class="button button2">Submit</button>
      </form>
      
     
      <div>
      
     
   
      <c:forEach var="tempEmployee" items="${EMPLOYEE_LIST}">
  <tr>    
    <td>${tempEmployee.fName} ${tempEmployee.lName}</td>
    <td>${tempEmployee.email}</td>
    
	<c:url var="deleteLink" value="UserControllerServlet">
		<c:param name="command" value="DELETEEMPLOYEES" />
		<c:param name="EmpId" value="${tempEmployee.id}" />
	</c:url>
    
		<td><a href="${deleteLink}"
		onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false">
		Delete</a>	</td>
		     
		   
  </tr>
  </c:forEach>
    
  
</table>
</div>
</div>
</div>


  <div style="clear:both;"></div>
  <p>
  <a href="UserControllerServlet">Back to List</a>
  <br>
  <br>
<br>
<br>
<br>
<div id="footer" >
<a href="index.jsp" style="color: white">Request IT Support</a>


</div>

<script src="js/bootstrap.min.js"></script>
<script src="jquery-3.6.0.min.js"></script>
<script src="nightmode.js"></script>

</html>
  
