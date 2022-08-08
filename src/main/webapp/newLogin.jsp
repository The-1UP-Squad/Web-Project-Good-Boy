<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel="stylesheet" href="./CSS/stylesheet.css">
<title>Project Planner Application - Add Login</title>
</head>

<h1>
<p style="color:#000048; p style=font-family:"arial";> Register New Login  </h1>

<br>

<div class="formUser">
<form action="UserControllerServlet" method="GET" autocomplete="ON">
<input type="hidden" name="command" value="ADDUSERPASSWORD"/>

<label for="uName"><b>Username:</b>&ensp;&nbsp;&nbsp; </label>
<input type="text" id="fName" name="uName"/><br><br>

<label for="passWord"><b>Password:</b>&emsp;&nbsp;</label>
<input type="password" id="password" name="passWord"/><br><br>
<br>
<br>
<br>
<br>

<button class="button button2">Submit</button>
<br/>
<br/>
</form>
</div>
</html>