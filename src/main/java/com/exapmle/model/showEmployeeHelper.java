package com.exapmle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class showEmployeeHelper {
	private String url = "jdbc:mysql://localhost:3306/mysql";
	private String user = "root";
	private String pw = "root";
	public List<Employee> getResult(){
		try(
				Connection conn = DriverManager.getConnection(
					url, user, pw);
				Statement stmt = conn.createStatement();
		){
			String sql = "select * from antra.Employee";
			ResultSet rset = stmt.executeQuery(sql);
			List<Employee> ret = new ArrayList<Employee>();
			while(rset.next()){
				int EId = rset.getInt("EId");
				String Name = rset.getString("Name");
				int DeptId = rset.getInt("DeptId");
				int ProjId = rset.getInt("ProjectId");
				
				String Department = "";
				String Project = "";
				
				Statement stmt1 = conn.createStatement();
				String sql1 = "select DeptName from antra.Department where DeptId = " + DeptId;
				ResultSet rset1 = stmt1.executeQuery(sql1);
				if(rset1.next()){
					Department = rset1.getString("DeptName");
				}
				
				Statement stmt2 = conn.createStatement();
				String sql2 = "select ProjName from antra.Project where ProjId = " + ProjId;
				ResultSet rset2 = stmt2.executeQuery(sql2);
				if(rset2.next()){
					Project = rset2.getString("ProjName");
				}

				Employee e = new Employee(EId, Name, DeptId, ProjId, Department, Project);
				ret.add(e);
			}
			return ret;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
}
