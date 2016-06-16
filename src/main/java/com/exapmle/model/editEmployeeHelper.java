package com.exapmle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class editEmployeeHelper {
	private String url = "jdbc:mysql://localhost:3306/mysql";
	private String user = "root";
	private String pw = "root";
	public Employee getResult(String EId){
		try(
				Connection conn = DriverManager.getConnection(
					url, user, pw);
				Statement stmt = conn.createStatement();
		){
			String sql = "select * from antra.Employee where EId =" + EId;
			ResultSet rset = stmt.executeQuery(sql);
			Employee e = null;
			while(rset.next()){
				int eId = rset.getInt("EId");
				String name = rset.getString("Name");
				int deptId = rset.getInt("DeptId");
				int projId = rset.getInt("ProjectId");

				String Department = "";
				String Project = "";
				Statement stmt1 = conn.createStatement();
				String sql1 = "select DeptName from antra.Department where DeptId = " + deptId;
				ResultSet rset1 = stmt1.executeQuery(sql1);
				if(rset1.next()){
					Department = rset1.getString("DeptName");
				}
				
				Statement stmt2 = conn.createStatement();
				String sql2 = "select ProjName from antra.Project where ProjId = " + projId;
				ResultSet rset2 = stmt2.executeQuery(sql2);
				if(rset2.next()){
					Project = rset2.getString("ProjName");
				}

				e = new Employee(eId, name, deptId, projId, Department, Project);

			}
			return e;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
}
