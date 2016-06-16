package com.example.web;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exapmle.model.registerDB;

public class registerServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		registerDB rdb = new registerDB();
		String ret = rdb.Conn(username, password);
		if(ret.equals("Succeed")){
			System.out.println("Successful!");
			HttpSession session = request.getSession();
			String sid = session.getId();
			session.setAttribute("username", username);
			session.setAttribute("sid", sid);
			RequestDispatcher view = request.getRequestDispatcher("welcome.jsp");
			view.forward(request, response);
			//response.sendRedirect("welcome.jsp");
		}else if(ret.equals("Duplicate")){
			System.out.println("Duplicate!");
			response.sendRedirect("register.jsp");
		}
	}
}
