package com.example.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exapmle.model.Employee;
import com.exapmle.model.deleteEmployeeHelper;
import com.exapmle.model.showEmployeeHelper;

public class deleteEmployee extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String EId = request.getParameter("hidden");
		deleteEmployeeHelper deh = new deleteEmployeeHelper();
		deh.delete(EId);
		showEmployeeHelper sEH = new showEmployeeHelper();
		List<Employee> result = sEH.getResult();
		request.setAttribute("result", result);
		RequestDispatcher view = request.getRequestDispatcher("employeeResult.jsp");
		view.forward(request, response);
	}
}
