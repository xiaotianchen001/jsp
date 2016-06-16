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
		<h1>Employee Edit Page</h1>
		<%
			String username = (String) session.getAttribute("username");
			String sid = (String) session.getAttribute("sid");
		%>

		<h3>
			User:
			<%=username%></h3>
		<h3>
			SID:
			<%=sid%></h3>

		<form method="POST" action="editFinish.do">
			<table border="0">
				<tr>
					<td><h4>Employee ID:</h4></td>
					<td><input type="text" name="EId" value=${emp["EId"]}></td>
				</tr>
				<tr>
					<td><h4>Employee Name:</h4></td>
					<td><input type="text" name="Name" value=${emp["name"]}></td>
				</tr>
				<tr>
					<td><h4>Department ID:</h4></td>
					<td><input type="text" name="DeptId" value=${emp["deptId"]}></td>
				</tr>
				<tr>
					<td><h4>Project ID:</h4></td>
					<td><input type="text" name="ProjectId" value=${emp["projectId"]}></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="eid" value=${eid} />
			<input type="submit" value="submit" />
		</form>
	</center>
</body>
</html>