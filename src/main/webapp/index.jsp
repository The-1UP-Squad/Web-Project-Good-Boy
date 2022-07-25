
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
   
      <link rel="stylesheet" href="./CSS/stylesheet.css">
      <script src="homepage.js"></script>
      <title>Project Planner Application</title>
      
      
     
    </head>
    

<h1><img src="logo.png" id="logo"><p style="color:#000048; p style=font-family:"arial";> Project Planner  </h1>

<body>
<h2>Welcome!</h2>
<p>What would you like to do?</p>

<nav>
    <div class="navbar">
      <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="adduser.jsp">Add a user</a></li>
        <li><a href="addproject.jsp">Add a project</a></li>
       
        
        
      </ul>
    </div>
<h2>Project List</h2>
<div id="time" ><% 
         Date dNow = new Date( );
         SimpleDateFormat ft = 
         new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
         out.print( "<h2 align=\"right\">" + ft.format(dNow) + "</h2>");
      %></div>
      
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for projects..">


<table id="myTable">
  <tr class="header">
    <th style="width: 33%;">Project Name</th>
    <th style="width: 33%;">Employee</th>
    <th style="width: 33%;"></th>
    <th style="width: 33%;">Modify</th>
    <th style="width: 33%;">Delete</th>
  </tr>
  <c:forEach var="tempEmployee" items="${EMPLOYEE_LIST}">
  <tr>
    <td>${tempEmployee.fName} </td>
    <td>${tempEmployee.lName}</td>
    <td>${tempEmployee.email}</td>
    <td>Edit</td>
    <td>Delete</td>
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


</html>