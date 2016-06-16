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
import com.exapmle.model.deptHelper;
import com.exapmle.model.editEmployeeHelper;
import com.exapmle.model.showDepartmentHelper;
import com.exapmle.model.showEmployeeHelper;

public class deptServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String btn = request.getParameter("btn");
		if(btn.equals("Create")){
			int DeptId = Integer.parseInt(request.getParameter("DeptId"));
			String DeptName = request.getParameter("DeptName");
			deptHelper dh = new deptHelper();
			String ret = dh.Create(DeptId, DeptName);
			if(ret.equals("Succeed")){
				System.out.println("Successful!");
				showDepartmentHelper sDH = new showDepartmentHelper();
				List<Department> result = sDH.getResult();
				request.setAttribute("result", result);
				RequestDispatcher view = request.getRequestDispatcher("departmentResult.jsp");
				view.forward(request, response);
			}else if(ret.equals("Duplicate")){
				System.out.println("Duplicate!");
				response.sendRedirect("createDept.jsp");
			}else if(ret.equals("Failed")){
				System.out.println("Databse Error!");
				response.sendRedirect("createDept.jsp");
			}
		}else if(btn.equals("Submit")){
			int CurId = Integer.parseInt(request.getParameter("CurId"));
			int DeptId = Integer.parseInt(request.getParameter("DeptId"));
			String DeptName = request.getParameter("DeptName");
			deptHelper dh = new deptHelper();
			String ret = dh.Update(DeptId, DeptName, CurId);
			if(ret.equals("Succeed")){
				showDepartmentHelper sDH = new showDepartmentHelper();
				List<Department> result = sDH.getResult();
				request.setAttribute("result", result);
				RequestDispatcher view = request.getRequestDispatcher("departmentResult.jsp");
				view.forward(request, response);
			}else{
				request.setAttribute("hidden", DeptId);
				request.setAttribute("hiddenname", DeptName);
				RequestDispatcher view = request.getRequestDispatcher("editDept.jsp");
				view.forward(request, response);
			}
		}else if(btn.equals("Delete")){
			int DeptId = Integer.parseInt(request.getParameter("hidden"));
			deptHelper dh = new deptHelper();
			dh.Delete(DeptId);
			showDepartmentHelper sDH = new showDepartmentHelper();
			List<Department> result = sDH.getResult();
			request.setAttribute("result", result);
			RequestDispatcher view = request.getRequestDispatcher("departmentResult.jsp");
			view.forward(request, response);
		}
	}
}
