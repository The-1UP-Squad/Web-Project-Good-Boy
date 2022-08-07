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

<form id="form_id" method="post" name="myform">

<p style=color:#000048; p style=font-family:"arial";>

<label>User Name :</label>
<input type="text" name="username" id="username"/>

<label>Password :</label>
<input type="password" name="password" id="password"/>
<br/>
<input type="button" value="Login" id="submit" onclick="validate()"/>
<span><b class="note">Note : </b>For this project use following username and password. 
<br/><b class="valid">User Name : User<br/>Password : Password</b></span>
</form>
<br/>
New User?
<a href="newLogin.jsp" >Register Here</a>
</div>
</div>
</body>
</html>