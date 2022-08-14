<!DOCTYPE html>
<html>
<head>
<title>Project Planner Application - Login</title>
<link rel="stylesheet" href="./CSS/stylesheet.css"/>
<link rel="stylesheet" href="./CSS/style.css"/>
<link rel="stylesheet" href="./CSS/REALprojectCSS.css"/>
<script src="login.js"></script>
</head>

<body>

<img class="middle" src="logo.png">

<div class="container">
<div class="main">


<h2>Project Planner Application - Login</h2>

<form id="form_id" action="UserControllerServlet" method="GET" name="myform">
<input type="hidden" name="command" value="CHECKUSERPASSWORD">
<script>window.history.pushState("UserControllerServlet", "listEmployees", "login.jsp")</script>
<p style=color:#000048; p style=font-family:"arial";>

<label>User Name :</label>
<input type="text" name="username" id="username"required/>

<label>Password :</label>
<input type="password" name="password" id="password"required/>
<br/>
<button class="button button2" >Submit</button>


</form>
<br/>
New User?
<a href="newLogin.jsp" >Register Here</a>
</div>
</div>
</body>
</html>