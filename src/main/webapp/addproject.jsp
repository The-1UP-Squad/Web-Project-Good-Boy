<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <link rel="stylesheet" href="./CSS/REALprojectCSS.css">
    <link rel="stylesheet" href="./CSS/stylesheet.css">
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <link rel="stylesheet" href="./CSS/highcontrast.css">
    <script src="homepage.js"></script>
    <title>Project Planner Application - Add Project</title>
  </head>
  
  <div class="mainlogo">
  <img class="middle" src="logo.png">
  <h1><p style=font-family:"arial";> New Project Form</h1>
  </div>
  
<nav>

   <div class="Logout">
   <a class="button button2" href="login.jsp"> Log Out </a>
   </div>
   
        <div class="highcontrast2">
   <a class="button button2" href='javascript:void(0);' onclick='retheme()' title='Change Theme'>High Contrast</a>
   </div>

    <div class="navbar">
      <c:url var="addUserLink" value="UserControllerServlet">
                <c:param name="command" value="LISTEMPLOYEES" />
                <c:param name="whereTo" value="1" />
		</c:url>
            <c:url var="addProjectLink" value="UserControllerServlet" >
                <c:param name="command" value="LISTPROJECTS" />
                <c:param name="whereTo" value="2" />
		</c:url>
      <ul>
        <li><a href="UserControllerServlet">Home</a></li>
        <li><a href="${addUserLink}">Users</a></li>
        <li><a href="${addProjectLink}">Projects</a></li>   
      </ul>
    </div>
</nav>
  <br>
  
   <div class="project-form">
   <form action="UserControllerServlet" method="GET">
<input type="hidden" name="command" value="ADDEMPLOYEEPROJECT"/>
	
      <label for="serviceline"><b>Project name:</b></label>
      <select id="project" name="pName">

  		<c:forEach var="projects" items="${PROJECT_LIST}"> 
   		<option>${projects.projName}</option>
		</c:forEach>
		</select>
		<p>
 
      <p>
      <label for="employee"><b>Employee:&emsp;&ensp;</b></label>
      <select id="pnameother" name="fName">
  		<c:forEach var="employees" items="${EMPLOYEE_LIST}"> 
   		<option>${employees.fName} ${employees.lName}</option>
		</c:forEach>
		</select>
      	<br><br>
		
	
      <label for="startdate"><b>Start Date:&emsp;&ensp;</b></label>
      <input type="date" id="startdate" name="startDate"><br><br>
      
      <label for="enddate"><b>End Date:&emsp;&ensp;&ensp;</b></label>
      <input type="date" id="enddate" name="endDate"><br><br><br><br>
      
      <button class="button button2">Submit</button>
  </form>
 <form action="UserControllerServlet" method="GET">
 	<input type="hidden" name="command" value="ADDPROJECT">
    <div class="container">
  <a class="button button2" href="#popup">Add Project</a>&emsp;&emsp;
  <div class="popup" id="popup">
    <div class="popup-inner">
      <div class="popuptext">      
        <p><label for="pnameother"><b>Add Project:</b></label>
      <input type="text" id="pnameother" name="pName"><br><br></p>
      <button class="button button2">Submit</button>
      </div>
      <a class="closepopup" href="#">X</a>
    </div>
  </div>
</div>
</form> 
  
  <div>

  <h2>Current Projects</h2>

  <input type="text" id="myInput" onkeyup="myFunction(`myInput`, `myTableProject`, `tr`)" placeholder="Search for projects..">
  
  <div style="overflow: auto; max-height: 350px; width: 900px;">
      
  <table id="myTableProject" style="width: 100%;">
  <tr class="header">

    <th style="width: 22%;">Project Name</th>
    <th style="width: 31%;"></th>
    <th style="width: 15%;">Delete Project</th>
    <th style="width: 33%;"></th>
    <th style="width: 33%;"></th>
   
    
  </tr>
  
        <c:forEach var="tempProject" items="${PROJECT_LIST}">
  <tr>    
    <td>${tempProject.projName}</td>
    
	<c:url var="deleteLink" value="UserControllerServlet">
		<c:param name="command" value="DELETEPROJECT" />
		<c:param name="ProID" value="${tempProject.projId}" />
		<c:param name="nameProject" value="${tempProject.projName}"/>
	</c:url>
   <td></td>
   
		<td><a href="${deleteLink}"
		onclick="if (!(confirm('Are you sure you want to delete this Project?'))) return false">
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