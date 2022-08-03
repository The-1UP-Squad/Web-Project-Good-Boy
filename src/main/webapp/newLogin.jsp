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
<input type="hidden" name="command" value="ADDEMPLOYEE"/>

<label for="fName"><b>First name:</b>&ensp;&nbsp;&nbsp; </label>
<input type="text" id="fName" name="fName"/><br><br>

<label for="lName"><b>Last name:</b>&ensp;&nbsp;&nbsp; </label>
<input type="text" id="lName" name="lName"/><br><br>

<label for="email"><b>Email:</b>&emsp;&emsp;&emsp;&nbsp;</label>
<input type="text" id="email" name="email"/><br><br>

<label for="password"><b>Password:</b>&emsp;&emsp;&emsp;&nbsp;</label>
<input type="text" id="email" name="password"/><br><br>
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