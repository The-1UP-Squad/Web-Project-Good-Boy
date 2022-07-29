<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <link rel="stylesheet" href="./CSS/stylesheet.css">
    <script src="homepage.js"></script>
    <title>Project Planner Application - Add User</title>
  </head>

<h1><img src="logo.png" id="logo"><p style="color:#000048; p style=font-family:"arial";> New User Form  </h1>

<nav>
    <div class="navbar">
      <c:url var="addUserLink" value="UserControllerServlet">
                <c:param name="command" value="LISTEMPLOYEES" />
                <c:param name="whereTo" value="1" />
		</c:url>
            <c:url var="addProjectLink" value="UserControllerServlet">
                <c:param name="command" value="LISTPROJECTS" />
                <c:param name="whereTo" value="2" />
		</c:url>
      <ul>
        <li><a href="http://localhost:8086/Web-Project-Good-Boy/">Home</a></li>
        <li><a href="${addUserLink}">Users</a></li>
        <li><a href="${addProjectLink}">Projects</a></li>   
      </ul>
    </div>
</nav>
  
  <br>
  
    
  <div class="formUser">
  <form action="UserControllerServlet" method="GET" autocomplete="ON">
<input type="hidden" name="command" value="ADDEMPLOYEE"/>
      <label for="fName"><b>First name:</b>&ensp;&nbsp;&nbsp; </label>
	  <input type="text" id="fName" name="fName"/><br><br>
	  
      <label for="lName"><b>Last name:</b>&ensp;&nbsp;&nbsp; </label>
      <input type="text" id="lName" name="lName"/><br><br>
      
      <label for="email"><b>Email:</b>&emsp;&emsp;&emsp;&nbsp;</label>
      <input type="text" id="email" name="email"/><br><br>
      
      <label for="serviceline"><b>Service Line:</b></label>
      <select id="serviceline" name="serviceline">
      
      <option value="software">Software Development</option>
      <option value="cloud">Cloud</option>
      <option value="AIML">AI and Machine Learning</option>
      </select> <br><br>
      
  <br><br><br><br>
      <button class="button button2">Submit</button>
      </form>
      
          <div class="container2">
  <a class="button button2" href="#popup">Add Service Line</a>&emsp;&emsp;
  <div class="popup" id="popup">
    <div class="popup-inner">
      <div class="popuptext">      
        <p><label for="pnameother"><b>Add New Service Line:</b></label>
      <input type="text" id="pnameother" name="pName"><br><br></p>
      <button class="button button2">Submit</button>
      </div>
      <a class="closepopup" href="#">X</a>
    </div>
  </div>
</div>
      
     
      <div>
      <h2> Current Employees at Cognizant</h2>
      
     <input type="text" id="myInput" onkeyup="myFunction(`myInput`, `myTableUser`, `tr`)" placeholder="Search for Employees..">
      
     <div style="overflow: auto; max-height: 350px; width: 900px;">
    <table id="myTableUser" style="width: 100%;">
  	<tr class="header">



    <th style="width: 33%;">Name</th>
    <th style="width: 33%;">Email</th>
    <th style="width: 10%;">Delete</th>
  
 

        
 
    
    </tr>
   
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
<a href="index.jsp" style="color: white">Request One IT Support</a>


</div>

  
</html>