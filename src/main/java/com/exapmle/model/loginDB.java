package com.exapmle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginDB {
	private String url = "jdbc:mysql://localhost:3306/mysql";
	private String user = "root";
	private String pw = "root";
	public boolean Conn(String username, String password){
		try(
				Connection conn = DriverManager.getConnection(
					url, user, pw);
				Statement stmt = conn.createStatement();
		){
			if(username == null || password == null ||
			(username == "" && password == "")){
				//response.sendRedirect("index.jsp");
				return false;
			}
			String sql = "select password from antra.User where username =" + "'" + username + "'";
			ResultSet rset = stmt.executeQuery(sql);
			
			int rowCount = 0;
			while(rset.next()){
				String pw = rset.getString("password");
				if(!pw.equals(password)){
					System.out.println("Wrong Password!");
					return false;
				}else{
					System.out.println("Login Succeed!");
					rowCount ++;
					return true;
				}
			}
			
			if(rowCount == 0){
				//no user found
				System.out.println("No record!");
				return false;
			}
			
			return true;
			
		}catch(SQLException ex){
			ex.printStackTrace();
			return false;
		}
	}
}
