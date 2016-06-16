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
import com.exapmle.model.editEmployeeHelper;
import com.exapmle.model.showEmployeeHelper;
import com.exapmle.model.submitEditHelper;

public class submitEdit extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//HttpSession session = request.getSession();
		String EId = request.getParameter("eid");
		int nEId = Integer.parseInt(request.getParameter("EId"));
		String nName = request.getParameter("Name");
		int nDeptId = Integer.parseInt(request.getParameter("DeptId"));
		int  nProjectId = Integer.parseInt(request.getParameter("ProjectId"));
		Employee e = new Employee(nEId, nName, nDeptId, nProjectId, "", "");
		submitEditHelper seh = new submitEditHelper();
		String ret = seh.updateEMP(EId, e);
		if(ret.equals("Succeed")){
			showEmployeeHelper sEH = new showEmployeeHelper();
			List<Employee> result = sEH.getResult();
			request.setAttribute("result", result);
			RequestDispatcher view = request.getRequestDispatcher("employeeResult.jsp");
			view.forward(request, response);
		}else{
			editEmployeeHelper eeh = new editEmployeeHelper();
			Employee emp = eeh.getResult(EId);
			request.setAttribute("eid", EId);
			request.setAttribute("emp", emp);
			RequestDispatcher view = request.getRequestDispatcher("editEmployee.jsp");
			view.forward(request, response);
			//response.sendRedirect("editEmployee.jsp");
		}
	} 
}
