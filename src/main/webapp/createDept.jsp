<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Create Department Page</h1>
		<%
			String username = (String) session.getAttribute("username");
			String sid = (String) session.getAttribute("sid");
		%>

		<h3>
			User:
			<%=username%>
		</h3>
		<h3>
			SID:
			<%=sid%>
		</h3>

		<form method="POST" action="deptServlet.do">
			<table border="0">
				<tr>
					<td><h4>Department ID:</h4></td>
					<td><input type="text" name="DeptId"></td>
				</tr>
				<tr>
					<td><h4>Department Name:</h4></td>
					<td><input type="text" name="DeptName"></td>
				</tr>
			</table>
			<br> 
			<input type="submit" value="Submit" />
			<input type="hidden" name="btn" value="Create"/>
		</form>
	</center>
</body>
</html>