package com.exapmle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class registerDB {
	private String url = "jdbc:mysql://localhost:3306/mysql";
	private String user = "root";
	private String pw = "root";
	public String Conn(String username, String password){
		try(
			Connection conn = DriverManager.getConnection(
					url, user, pw);
			Statement stmt = conn.createStatement();
		){
			if(username == null || password == null ||
					(username == "" && password == "")){
				return "InvalidInput";
			}
			
			//check duplicate
			String checkSql = "select username from antra.User where username =" + "'" + username + "'";
			ResultSet rset = stmt.executeQuery(checkSql);
			
			int rowCount = 0;
			while(rset.next()){
				rowCount ++;
			}

			
			
			if(rowCount != 0){
				return "Duplicate";
			}else{
				String sql = "insert into antra.User values(" + "'" + username + "', '" + password + "')";
				stmt.executeUpdate(sql);
				return "Succeed";
			}
		}catch(SQLException ex){
			ex.printStackTrace();
			return "Failed";
		}
	}
}
