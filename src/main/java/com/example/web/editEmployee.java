package com.example.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exapmle.model.Employee;
import com.exapmle.model.editEmployeeHelper;

public class editEmployee extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//HttpSession session = request.getSession();
		String EId = request.getParameter("hidden");
		editEmployeeHelper eeh = new editEmployeeHelper();
		Employee e = eeh.getResult(EId);
		request.setAttribute("eid", EId);
		request.setAttribute("emp", e);
		RequestDispatcher view = request.getRequestDispatcher("editEmployee.jsp");
		view.forward(request, response);
	}
}
