<html>
    <head>
   
      <link rel="stylesheet" href="./CSS/stylesheet.css">
      <script src="homepage.js"></script>
      <title>Project Planner Application</title>
      
     
    </head>

<h1><img src="logo.png" id="logo">Project Planner</h1>

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
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for projects..">

<table id="myTable">
  <tr class="header">
    <th style="width: 33%;">Project Name</th>
    <th style="width: 33%;">Employee</th>
    <th style="width: 33%;">Modify</th>
  </tr>
  <tr>
    <td>Java</td>
    <td>Matthew Cockram</td>
    <td>Edit</td>
  </tr>
  <tr>
    <td>Eclipse</td>
    <td>Sandra Longbottom</td>
    <td>Edit</td>
  </tr>
  <tr>
    <td>Python</td>
    <td>Emma Watson</td>
    <td>Edit</td>
  </tr>
  <tr>
    <td>Linux</td>
    <td>Harry Hamlton</td>
    <td>Edit</td>
  </tr>
</table>


</nav>
<br>
<br>
<br>
<div id="footer" >
<a href="index.jsp" style="color: white">Request One IT Support</a>

</div>

</body>




</html>