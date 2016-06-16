package com.example.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exapmle.model.loginDB;

public class loginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			loginDB ldb = new loginDB();
			if(ldb.Conn(username, password)){
				System.out.println("Success");
				HttpSession session = request.getSession();
				String sid = session.getId();
				session.setAttribute("username", username);
				session.setAttribute("sid", sid);
				RequestDispatcher view = request.getRequestDispatcher("welcome.jsp");
				view.forward(request, response);
				//response.sendRedirect("welcome.jsp");
			}else{
				System.out.println("Failed!");
				response.sendRedirect("index.jsp");
			}
	}
}
