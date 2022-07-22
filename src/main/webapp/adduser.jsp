<html>
  <head>
    <link rel="stylesheet" href="./CSS/stylesheet.css">
    <title>Project Planner Application - Add User</title>
  </head>

  <h1>New User Form</h1>

  <nav>
      <div class="menu">
        <ul>
          <li><a href="index.jsp">Home</a></li>
          <li><a href="adduser.jsp">Add a user</a></li>
          <li><a href="addproject.jsp">Add a project</a></li>
        </ul>
      </div>
  </nav>
  <br>
  <form action="UserControllerServlet" method="GET">
<input type="hidden" name="command" value="ADD"/>
      <label for="fname">First name:&ensp;&nbsp; </label>

      <input type="text" id="fname" name="fname"><br><br>
      <label for="lname">Last name:&ensp;&nbsp; </label>
      <input type="text" id="lname" name="lname"><br><br>
      <label for="email">Email:&emsp;&emsp;&emsp;</label>
      <input type="text" id="email" name="email"><br><br>
      <label for="serviceline">Service Line:</label>
      <select name="serviceline">
      <option value="software">Software Development</option>
      <option value="cloud">Cloud</option>
      <option value="AIML">AI & Machine Learning</option>
      </select> <br><br>
      <label for="other">Other:</label>
      <input type="text" id="other" name="other"><br><br>
     
  </form>
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