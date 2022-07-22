<%@ page import = "java.util.*, com.project.api.web.www.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Employee Tracker App</title>
</head>
<%
List<Employee> theEmployees =
(List<Employee>) request.getAttribute("EMPLOYEE_LIST");

%>
<body>
<%= theEmployees %>

</body>
</html>