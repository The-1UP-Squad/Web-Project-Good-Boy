<html>
  <head>
    <link rel="stylesheet" href="./CSS/stylesheet.css">
    <title>Project Planner Application - Login</title>
  </head>
  <body>
<div class="logo">
<img src="logo.png" id="logo"><p style=color:#000048; p style=font-family:"arial";>
</div>
  <br>
  
<div class="containerusername">
        <label for="email"><b>Email:</b> </label>
	  <input type="text" id="email" name="email"/><br><br>
</div>
<div class="containerpassword">	  
      <label for="pass"><b>Password:</b></label>
      <input type="password" id="pass" name="pass"/><br><br>
</div>
      
      <div class="loginbutton">
      <a class="button button2" href="http://localhost:8086/Web-Project-Good-Boy/UserControllerServlet"> Login </a>
      </div>
      
<div class="register">
  <a class="button button2" href="#popup">Register</a>&emsp;&emsp;
  <div class="popup" id="popup">
    <div class="popup-inner">
      <div class="popuptext">      
        <p><label for="email"><b>Email:</b></label>
      <input type="text" id="email" name="enrollEmail"></p>
       <p><label for="password"><b>Password:</b></label>
       
      <input type="text" id="password" name="enrollPassword"><br><br></p>
      <a class="button button2" href="http://localhost:8086/Web-Project-Good-Boy/UserControllerServlet"> Submit </a>
      
      
      </div>
      <a class="closepopup" href="#">X</a>
    </div>
  </div>
</div>   
  <div style="clear:both;"></div>
  <p>
  <br>
  <br>
<br>
<br>
<br>

  </body>
</html>