package com.example.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exapmle.model.Employee;
import com.exapmle.model.createEmployeeHelper;
import com.exapmle.model.showEmployeeHelper;

public class createEmployee extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {	
		int EId = Integer.parseInt(request.getParameter("EId"));
		String Name = request.getParameter("Name");
		int DeptId = Integer.parseInt(request.getParameter("DeptId"));
		int ProjectId = Integer.parseInt(request.getParameter("ProjectId"));
		Employee e = new Employee(EId, Name, DeptId, ProjectId, "", "");
		createEmployeeHelper ceh = new createEmployeeHelper();
		String ret = ceh.Create(e);
		System.out.println(ret);
		if(ret.equals("Succeed")){
			System.out.println("Successful!");
			showEmployeeHelper sEH = new showEmployeeHelper();
			List<Employee> result = sEH.getResult();
			request.setAttribute("result", result);
			RequestDispatcher view = request.getRequestDispatcher("employeeResult.jsp");
			view.forward(request, response);
		}else if(ret.equals("Duplicate")){
			System.out.println("Duplicate!");
			response.sendRedirect("createEmployee.jsp");
		}else if(ret.equals("Failed")){
			System.out.println("Databse Error!");
			response.sendRedirect("createEmployee.jsp");
		}
	}
}
