package com.example.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exapmle.model.Employee;
import com.exapmle.model.showEmployeeHelper;

public class showEmployee extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		showEmployeeHelper seh = new showEmployeeHelper();
		List<Employee> result = seh.getResult();
		request.setAttribute("result", result);
		RequestDispatcher view = request.getRequestDispatcher("employeeResult.jsp");
		view.forward(request, response);
	}
}
