<html>
  <head>
    <link rel="stylesheet" href="./CSS/stylesheet.css">
    <title>Project Planner Application - Add User</title>
  </head>

<h1><img src="logo.png" id="logo"><p style="color:#000048; p style=font-family:"arial";> New User Form  </h1>

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
  <form action="UserControllerServlet" method="GET">
<input type="hidden" name="command" value="ADDEMPLOYEE"/>
      <label for="fName"><b>First name:</b>&ensp;&nbsp;&nbsp; </label>
	  <input type="text" id="fName" name="fName"/><br><br>
	  
      <label for="lName"><b>Last name:</b>&ensp;&nbsp;&nbsp; </label>
      <input type="text" id="lName" name="lName"/><br><br>
      
      <label for="email"><b>Email:</b>&emsp;&emsp;&emsp;&nbsp;</label>
      <input type="text" id="email" name="email"/><br><br>
      
      <label for="serviceline"><b>Service Line:</b></label>
      <select id="serviceline" name="serviceline">
      
      <option value="software">Software Development</option>
      <option value="cloud">Cloud</option>
      <option value="AIML">AI and Machine Learning</option>
      </select> <br><br>
      
      <label for="other"><b>Other:</b>&emsp;&emsp;&emsp;&nbsp;</label>
      <input type="text" id="other" name="other"><br><br><br><br>
      
      <button class="button button2">Submit</button>
     
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