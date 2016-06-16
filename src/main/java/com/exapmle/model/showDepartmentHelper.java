package com.exapmle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class showDepartmentHelper {
	private String url = "jdbc:mysql://localhost:3306/mysql";
	private String user = "root";
	private String pw = "root";
	public List<Department> getResult(){
		try(
				Connection conn = DriverManager.getConnection(
					url, user, pw);
				Statement stmt = conn.createStatement();
		){
			String sql = "select * from antra.Department";
			ResultSet rset = stmt.executeQuery(sql);
			List<Department> ret = new ArrayList<Department>();
			while(rset.next()){
				int DeptId = rset.getInt("DeptId");
				String DeptName = rset.getString("DeptName");
				Department d = new Department(DeptId, DeptName);
				ret.add(d);
			}
			return ret;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
}
