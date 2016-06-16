package com.exapmle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class createEmployeeHelper {
	private String url = "jdbc:mysql://localhost:3306/mysql";
	private String user = "root";
	private String pw = "root";
	public String Create(Employee e){
		try(
			Connection conn = DriverManager.getConnection(
					url, user, pw);
			Statement stmt = conn.createStatement();
		){
			int eid = e.getEId();
			String name = e.getName();
			int deptid = e.getDeptId();
			int projectid = e.getProjectId();
			if(eid == -1 || name == null || deptid == -1 ||
					(name == "")){
				return "InvalidInput";
			}
			
			//check duplicate
			String checkSql = "select EId from antra.Employee where EId =" + "'" + eid + "'";
			ResultSet rset = stmt.executeQuery(checkSql);
			
			int rowCount = 0;
			while(rset.next()){
				rowCount ++;
			}
			
			if(rowCount != 0){
				return "Duplicate";
			}else{
				String sql = "insert into antra.Employee values(" + "'" + eid + "', '" + name + 
						"', '" + deptid + "', '" + projectid + "')";
				stmt.executeUpdate(sql);
				return "Succeed";
			}
		}catch(SQLException ex){
			ex.printStackTrace();
			return "Failed";
		}
	}
}
