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
          <li><a href="http://localhost:8086/Web-Project-Good-Boy/UserControllerServlet?command=LISTEMPLOYEES&whereTo=1">Users</a></li>
          <li><a href="addproject.jsp">Projects</a></li>
        </ul>
      </div>
  </nav>
  <br>
  
   <div class="project-form">
   <form action="UserControllerServlet" method="GET">
	<input type="hidden" name="command" value="ADDEMPLOYEEPROJECT"/>
	
      <label for="serviceline"><b>Project name:</b></label>
      <select id="project" name="pName">
      <option value="7 West">ANZ</option>
      <option value="SRG">Super Retail Group</option>
      <option value="Telstra">Telstra</option>

      </select> 
      <br><br>	
      
      <label for="employee"><b>Employee:&emsp;&ensp;</b></label>
      <select id="employee" name="fName">

      <option value="Matthew">Matthew</option>
      <option value="Emma">Emma</option>
      <option value="Siobhan">Siobhan</option>
      
      </select>
      <br><br>


      <label for="startdate"><b>Start Date:&emsp;&ensp;</b></label>
      <input type="date" id="startdate" name="startDate"><br><br>
      
      <label for="enddate"><b>End Date:&emsp;&ensp;&ensp;</b></label>
      <input type="date" id="enddate" name="endDate"><br><br><br><br>
      
      <button class="button button2">Submit</button>
  </form>
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
 
  
  <div>
  <h2>Current Projects at Cognizant</h2>
  <input type="text" id="myInput1" onkeyup="myFunction()" placeholder="Search for projects..">
  
      
  <table id="myTableProject">
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