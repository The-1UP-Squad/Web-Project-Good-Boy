<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <link rel="stylesheet" href="./CSS/stylesheet.css">
    <link rel="stylesheet" href="./CSS/highcontrast.css">
    <title>Project Planner Application - Modify</title>
  </head>

<div class="mainlogo">
<img class="middle" src="logo.png">
<h1><p style="color:#000048; p style=font-family:"arial";> Modify  </h1>
</div>

        <div class="highcontrast">
   <a class="button button2" href='javascript:void(0);' onclick='retheme()' title='Change Theme'>High Contrast</a>
   </div>

  <nav>
      <div class="menu">
        <ul>
          <li><a href="UserControllerServlet"></a></li>
          <li><a href="adduser.jsp"></a></li>
          <li><a href="addproject.jsp"></a></li>
        </ul>
      </div>
  </nav>
  <br>
  <form action="UserControllerServlet" method="GET">
  	<input type="hidden" name="command" value="UPDATEINDEX"/>
  	<input type="hidden" name="employeeProjectId" value="${THE_EMPLOYEEPROJECT.pId}"/>  		
     
	  <label for="serviceline"><b>Project name:</b></label>
      <select id="project" name="project">
	<option>${THE_EMPLOYEEPROJECT.pName}</option>
  	<c:forEach var="projects" items="${PROJECT_LIST}"> 
   	  <option>${projects.projName}</option>
	  </c:forEach>
	  </select> <br><br>
      
      
      <label for="employee"><b>Employee:&emsp;&ensp;</b></label>
      <select id="employee" name="employee">
      <option>${THE_EMPLOYEEPROJECT.fName}</option>
      <c:forEach var="employees" items="${EMPLOYEE_LIST}">
      <option>${employees.fName} ${employees.lName}</option>
      </c:forEach>
      </select> <br><br>
      
      <label for="startdate"><b>Start Date:&emsp;&ensp;</b></label>
      <input type="date" id="startdate" name="startdate" value="${THE_EMPLOYEEPROJECT.startDate}"><br><br>
      
      <label for="enddate"><b>End Date:&emsp;&ensp;&ensp;</b></label>
      <input type="date" id="enddate" name="enddate" value="${THE_EMPLOYEEPROJECT.endDate}"><br><br><br><br>
      
      <label for="projectID"></label>
      <input type="hidden" id="projectID" name="employeeProject" value="${THE_EMPLOYEEPROJECT.pId}"/>
      <button class="button button2">Submit</button>&emsp;&emsp;
      
 	</form>       
     
<button onclick="document.location= 'UserControllerServlet'" class="button button2">Back</button>
  <div style="clear:both;"></div>
  <p>
  <br>
  <br>
<br>
<br>
<br>
<div id="footer" >
<a href="index.jsp" style="color: white">Request IT Support</a>


</div>

<script src="nightmode.js"></script>
  
</html>