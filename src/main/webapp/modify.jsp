<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <link rel="stylesheet" href="./CSS/stylesheet.css">
    <title>Project Planner Application - Modify</title>
  </head>

<h1><img src="logo.png" id="logo"><p style="color:#000048; p style=font-family:"arial";> Modify  </h1>

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
  	<input type="hidden" name="command" value="LISTEMPLOYEEPROJECTS">
  	
     
	  <label for="serviceline"><b>Project name:</b></label>
      <select id="project" name="project">
	  <c:forEach var="employeeProjects" items="${EMPLOYEEPROJECT_LIST}">
	  <option>${employeeProjects.pName}</option>
	  </c:forEach>
      </select> <br><br>
      
      
      <label for="employee"><b>Employee:&emsp;&ensp;</b></label>
      <select id="employee" name="employee">
      <c:forEach var="employeeProjects" items="${EMPLOYEEPROJECT_LIST}">
      <option>${employeeProjects.fName}</option>
      </c:forEach>
      </select> <br><br>
      
      <label for="startdate"><b>Start Date:&emsp;&ensp;</b></label>
      <input type="date" id="startdate" name="startdate"><br><br>
      <label for="enddate"><b>End Date:&emsp;&ensp;&ensp;</b></label>
      <input type="date" id="enddate" name="enddate"><br><br><br><br>
      
      <button class="button button2">Submit</button>&emsp;&emsp;<button onclick="document.location= 'http://localhost:8086/Web-Project-Good-Boy/UserControllerServlet'" class="button button2">Back</button>
      
 	</form>       
     

  <div style="clear:both;"></div>
  <p>
  <br>
  <br>
<br>
<br>
<br>
<div id="footer" >
<a href="index.jsp" style="color: white">Request One IT Support</a>


</div>

  
</html>