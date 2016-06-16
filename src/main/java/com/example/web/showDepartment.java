package com.example.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exapmle.model.Department;
import com.exapmle.model.Employee;
import com.exapmle.model.showDepartmentHelper;
import com.exapmle.model.showEmployeeHelper;

public class showDepartment extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		showDepartmentHelper sdh = new showDepartmentHelper();
		List<Department> result = sdh.getResult();
		request.setAttribute("result", result);
		RequestDispatcher view = request.getRequestDispatcher("departmentResult.jsp");
		view.forward(request, response);
	}

}
