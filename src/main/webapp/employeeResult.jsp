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
		<h1>Employee Result List</h1>
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
		<table border='1'>
			<tr>
				<td><h4>Employee ID</h4></td>
				<td><h4>Employee Name</h4></td>
				<td><h4>Department</h4></td>
				<td><h4>Project</h4></td>
				<th colspan="2">Actions</th>
			</tr>
			<br>
			<br>
			<c:forEach var="employee" items="${result}">
				<tr>
					<td>${employee["EId"]}</td>
					<td>${employee["name"]}</td>
					<td>${employee["department"]}</td>
					<td>${employee["project"]}</td>
					<td>
						<form method="POST" action="editEmployee.do">
							<input type="submit" value="Edit" /> <input type="hidden"
								name="hidden" value=${employee["EId"]} />
						</form>
					</td>
					<td>
						<form method="POST" action="deleteEmployee.do">
							<input type="submit" value="Delete" /> <input type="hidden"
								name="hidden" value=${employee["EId"]} />
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<table border="0">
			<tr>
				<th colspan="2">
					<form method="POST" action="createEmployee.jsp">
						<input type="submit" name="btn" value="Create" />
					</form>
				</th>
				<th colspan="2">
					<form method="POST" action="welcome.jsp">
						<input type="submit" name="btn" value="Back" />
					</form>
				</th>
			</tr>
		</table>

	</center>
</body>
</html>