<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Welcome Page</h1>
<%
	String username = (String)session.getAttribute("username");
	String sid = (String)session.getAttribute("sid");
%>

<h3>User: <%= username %></h3>
<h3>SID: <%= sid %></h3>

<table border='0'>
<tr>
<td>
<form method="POST" action="Employee.do">
	<input type="submit" value="Employee Operations" />
</form>
</td>
<td><br><br><br></td>
</tr>
<tr>
<td>
<form method="POST" action="Department.do">
	<input type="submit" value="Department Operations" />
</form>
</td>
<td><br><br><br></td>
</tr>
<tr>
<td>
<form method="POST" action="Project.do">
	<input type="submit" value="Project Operations" />
</form>
</td>
<td><br><br><br></td>
</tr>
</table>

</center>
</body>
</html>