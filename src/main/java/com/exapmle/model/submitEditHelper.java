package com.exapmle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class submitEditHelper {
	private String url = "jdbc:mysql://localhost:3306/mysql";
	private String user = "root";
	private String pw = "root";
	public String updateEMP(String EId, Employee e){
		try(
				Connection conn = DriverManager.getConnection(
					url, user, pw);
				Statement stmt = conn.createStatement();
		){
			String sql = "update antra.Employee set EId=" + e.getEId() +
					", Name='" + e.getName() + "', DeptId=" + e.getDeptId() + ", ProjectId='" + e.getProjectId() +
					"' where EId=" + EId; 
			
			int status = stmt.executeUpdate(sql);
			if(status > 0){
				System.out.println("Succeed");
				return "Succeed";
			}else{
				System.out.println("Failed");
				return "Failed";
			}
 		}catch(SQLException ex){
			ex.printStackTrace();
			return "Failed";
		}
		//return "Failed";
	}
}
