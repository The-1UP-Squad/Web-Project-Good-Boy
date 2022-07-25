<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./CSS/stylesheet.css">
<title>Employee Tracker App</title>
 
</head>

<body>

<h1><img src="logo.png" id="logo"><p style="color:#000048; p style=font-family:"arial";> Project Planner  </h1>

<div id="container"></div>
<div id="myTable">
<table>
  <tr class="header">
<th>First Name
</th>
<th>Last Name
</th>
<th>Email
</th>

</tr>
<c:forEach var="tempEmployee" items="${EMPLOYEE_LIST}">
<tr>
<td> ${tempEmployee.fName} </td>
<td> ${tempEmployee.lName}</td>
<td> ${tempEmployee.email} </td>
</tr>
</c:forEach>

</table>
</div>

 
</body>
</html>