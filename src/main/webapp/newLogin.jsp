<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel="stylesheet" href="./CSS/stylesheet.css">
<title>Project Planner Application - Add Login</title>
</head>
<img class="middle" src="logo.png">
<h1>
<p style="color:#000048; p style=font-family:"arial";> Register New Login  </h1>

<br>

<div class="formUser">
<form action="UserControllerServlet" method="GET" autocomplete="ON">
<input type="hidden" name="command" value="ADDUSERPASSWORD"/>

<label for="uName"><b>Username:</b>&ensp;&nbsp;&nbsp; </label>
<input type="text" id="fName" name="uName" placeholder="Enter your name here" required/><br><br>

<label for="passWord"><b>Password:</b>&emsp;&nbsp;</label>
<input type="password" id="password" name="passWord" placeholder="Enter your password here" required/><br><br>


  	<input type="hidden" name="command" value="ADDSERVICELINE">   
          <div class="containerhello">
  <a class="button button2" href="#popup">Create Login</a>&emsp;&emsp;
  <div class="popup" id="popup">
    <div class="popup-inner">
      <div class="popuptext">      
        <p><label for="pnameother"><h2>Please Login to Continue.</h2></label>
      <br><br></p>
      <button class="button button2">OK</button>
      </div>
      <a class="closepopup" href="#">X</a>
    </div>
  </div>
</div>
  </form>

<br/>
<br/>
</div>
</html>