<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <link rel="stylesheet" href="./CSS/REALprojectCSS.css">
    <link rel="stylesheet" href="./CSS/stylesheet.css">
    <script src="homepage.js"></script>
    <title>Project Planner Application - Add Project</title>
  </head>
  <h1><img src="logo.png" id="logo"><p style="color:#000048; p style=font-family:"arial";> New Project Form  </h1>

  <nav>
      <div class="menu">
        <ul>
          <li><a href="http://localhost:8086/Web-Project-Good-Boy/">Home</a></li>
          <li><a href="adduser.jsp">Add a user</a></li>
          <li><a href="addproject.jsp">Add a project</a></li>
        </ul>
      </div>
  </nav>
  <br>
  
  
   <div class="project-form">
   <form action="UserControllerServlet" method="GET">
	<input type="hidden" name="command" value="ADDPROJECT"/>
	
      <label for="serviceline"><b>Project name:</b></label>

      <select id="project" name="project">
      <option value="7 West">7 West</option>
      <option value="SRG">Super Retail Group</option>
      <option value="Telstra">Telstra</option>

      </select> 
      <br><br>

      <label for="pnameother"><b>Project other:</b></label>
      <input type="text" id="pnameother" name="pName"><br><br>
      
      <label for="employee"><b>Employee:&emsp;&ensp;</b></label>
      <select id="employee" name="employee">
      <option value="Matthew">Matthew</option>
      <option value="Emma">Emma</option>
      <option value="Siobhan">Siobhan</option>

      </select>
      <br><br>

      <label for="startdate"><b>Start Date:&emsp;&ensp;</b></label>
      <input type="date" id="startdate" name="startdate"><br><br>
      
      <label for="enddate"><b>End Date:&emsp;&ensp;&ensp;</b></label>
      <input type="date" id="enddate" name="enddate"><br><br><br><br>
      
      <button class="button button2">Submit</button>&emsp;&emsp;<button class="button button2">New Project</button>
  </form>
  
<div id="newProject" class="modal">

  <div class="projectContents">
    <span class="close">&times;</span>
    <p>      
    <label for="pnameother"><b>Project other:</b></label>
      <input type="text" id="pnameother" name="pName"><br><br>
      </p>
  </div>

</div>
  
  
  
  <div>
  <h2>Current Projects at Cognizant</h2>
  <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for projects..">
  
      
  <table id="myTable">
  <tr class="header">

    <th style="width: 20%;">Project Name</th>
    <th style="width: 25%;">Delete Project</th>
    
  </tr>
</table>
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