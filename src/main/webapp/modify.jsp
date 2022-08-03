<html>
  <head>
    <link rel="stylesheet" href="./CSS/stylesheet.css">
    <link rel="stylesheet" href="./CSS/highcontrast.css">
    <title>Project Planner Application - Modify</title>
  </head>

<div class="mainlogo">
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
      <label for="serviceline"><b>Project name:</b></label>
      <select id="project" name="project">
      <option value="7 West">7 West</option>
      <option value="SRG">Super Retail Group</option>
      <option value="Telstra">Telstra</option>
      </select> <br><br>
      <label for="employee"><b>Employee:&emsp;&ensp;</b></label>
      <select id="employee" name="employee">
      <option value="Matthew">Matthew</option>
      <option value="Emma">Emma</option>
      <option value="Siobhan">Siobhan</option>
      </select> <br><br>
      <label for="startdate"><b>Start Date:&emsp;&ensp;</b></label>
      <input type="date" id="startdate" name="startdate"><br><br>
      <label for="enddate"><b>End Date:&emsp;&ensp;&ensp;</b></label>
      <input type="date" id="enddate" name="enddate"><br><br><br><br>
      
      <button class="button button2">Submit</button>&emsp;&emsp;<button onclick="document.location= 'UserControllerServlet'" class="button button2">Back</button>
      
        
     

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