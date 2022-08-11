
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
   
      <link rel="stylesheet" href="./CSS/stylesheet.css">
      <link rel="stylesheet" href="./CSS/bootstrap.min.css">
      <link rel="stylesheet" href="./CSS/highcontrast.css">
      <script src="homepage.js"></script>
      <title>Project Planner Application</title>
      
      
     
    </head>
    
<div class="mainlogo">
<img class="middle" src="logo.png">

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
        <li><a class="active" href="UserControllerServlet">Home</a></li>
        <li><a href="${addUserLink}">Users</a></li>
        <li><a href="${addProjectLink}">Projects</a></li>  
      </ul>
    </div>
</nav>

<h1><p style=font-family:"arial";> Project Planner  </h1>
</div>

   <div class="Logout">
   <a class="button button2" href="login.jsp"> Log Out </a>
   </div>
   
     <div class="highcontrast">
   <a class="button button2" href='javascript:void(0);' onclick='retheme()' title='Change Theme'>High Contrast</a>
   </div>

<body>	
<h2>Project List</h2>
<div id="time" ><% 
         Date dNow = new Date( );
         SimpleDateFormat ft = 
         new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
         out.print( "<h6 align=\"right\">" + ft.format(dNow) + "</h6>");
      %></div>
      
<input type="text" id="myInput" onkeyup="myFunction(`myInput`, `myTable`, `tr`)" placeholder="Search for projects..">
<script>window.history.pushState("UserControllerServlet", "listEmployees", "UserControllerServlet")</script>

<table id="myTable">
  <tr class="header">

    <th style="width: 12.5%;">Project</th>
    <th style="width: 12.5%;">Employee</th>
    
    <th style="width: 12.5%;">Start Date</th>
    <th style="width: 12.5%;">End Date</th>
    <th style="width: 12.5%;">Modify</th>
    <th style="width: 12.5%;">Delete</th>
   

  </tr>
  <c:forEach var="tempEmpProject" items="${EMPLOYEEPROJECT_LIST}">
  	
  	
  	<c:url var="templink" value="UserControllerServlet">
		<c:param name="command" value="LOAD" />
		<c:param name="ProjectID" value="${tempEmpProject.pId}" />
		
	</c:url>
  <tr>
  	 
    <td>${tempEmpProject.pName}</td> 
    <td>${tempEmpProject.fName}</td>
    <td>${tempEmpProject.startDate}</td> 
    <td>${tempEmpProject.endDate} </td>
    
    
	
    
    
    
	<c:url var="deleteLink" value="UserControllerServlet">
		<c:param name="command" value="DELETEEMPLOYEEPROJECT" />
		<c:param name="ProjectID" value="${tempEmpProject.pId}" />
	</c:url>
	
	<c:url var="modifyLink" value="UserControllerServlet">
		<c:param name="command" value="LOAD"/>
		<c:param name="modifywhereto" value="1"/>
		<c:param name="ProjectID" value="${tempEmpProject.pId}"/>
	</c:url>
	
	<c:url var="populatelink" value ="UserControllerServlet">
	<c:param name="command" value="UPDATEINDEX" />
	</c:url>
    
    	<td><a href="${modifyLink}"
    	onclick="if (!(confirm('Are you sure you want to edit this Project?'))) return false">
    	Edit</a>	</td>
		
		<td><a href="${deleteLink}"
		onclick="if (!(confirm('Are you sure you want to delete this Project?'))) return false">
		Delete</a>	</td>
		     
		   
  </tr>
  </c:forEach>
</table>


<br>
<br>
<br>
<br>
<div id="footer" >
<a href="index.jsp" style="color: white">Request IT Support</a>

</div>

</body>

<script src="js/bootstrap.min.js"></script>
<script src="jquery-3.6.0.min.js"></script>
<script src="nightmode.js"></script>

</html>