
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
   
      <link rel="stylesheet" href="./CSS/stylesheet.css">
      <link rel="stylesheet" href="/CSS/bootstrap.min.css">
      <script src="homepage.js"></script>
      <title>Project Planner Application</title>
      
      
     
    </head>
    

<h1><img src="logo.png" id="logo"><p style="color:#000048; p style=font-family:"arial";> Project Planner  </h1>

<body>
<h2>Welcome!</h2>

   <div class="Logout">
   <button class="button button2">Logout</button>
   </div>
   
 <div class="myContainer">
   <div class="form-check form-switch">
    <input class="form-check-input" type="checkbox" id="nightModeSwitch">
    <label class="form-check-label" for="nightModeSwitch">Night Mode</label	>
	</div>
</div>

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
    
<h2>Project List</h2>
<div id="time" ><% 
         Date dNow = new Date( );
         SimpleDateFormat ft = 
         new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
         out.print( "<h2 align=\"right\">" + ft.format(dNow) + "</h2>");
      %></div>
      
<input type="text" id="myInput" onkeyup="myFunction(`myInput`, `myTable`, `tr`)" placeholder="Search for projects..">


<table id="myTable">
  <tr class="header">

    <th style="width: 12.5%;">Project</th>
    <th style="width: 12.5%;">Employee</th>
    <th style="width: 12.5%;">Email</th>
    <th style="width: 12.5%;">Start Date</th>
    <th style="width: 12.5%;">End Date</th>
    <th style="width: 12.5%;">Modify</th>
    <th style="width: 12.5%;">Delete</th>
    <th style="width: 12.5%;"></th>

  </tr>
  <c:forEach var="tempEmployee" items="${EMPLOYEE_LIST}">
  	
  	
  	<c:url var="templink" value="UserControllerServlet">
		<c:param name="command" value="LOAD" />
		<c:param name="EmpId" value="${tempEmployee.id}" />
	</c:url>
  <tr>    
    <td>${tempEmployee.fName} </td>
    <td>${tempEmployee.lName}</td>
    <td>${tempEmployee.email}</td>
    
    
	<td>10-07-2002</td>
    <td>10-09-2002</td>
    
    
    
	<c:url var="deleteLink" value="UserControllerServlet">
		<c:param name="command" value="DELETEEMPLOYEES" />
		<c:param name="EmpId" value="${tempEmployee.id}" />
	</c:url>
    
    	<td> <a href="${templink}">Edit</a>	</td>
		
		<td><a href="${deleteLink}"
		onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false">
		Delete</a>	</td>
		     
		   
  </tr>
  </c:forEach>
</table>


</nav>
<br>
<br>
<br>
<br>
<div id="footer" >
<a href="index.jsp" style="color: white">Request One IT Support</a>

</div>

</body>

<script src="js/bootstrap.min.js"></script>
<script src="jquery-3.5.1.min.js"></script>
<script src="nightmode.js"></script>

</html>