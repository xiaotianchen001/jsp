package com.exapmle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteEmployeeHelper {
	private String url = "jdbc:mysql://localhost:3306/mysql";
	private String user = "root";
	private String pw = "root";

	public void delete(String EId) {
		try (Connection conn = DriverManager.getConnection(url, user, pw);
				Statement stmt = conn.createStatement();) {
			
			String sql = "delete from antra.Employee where EId=" +EId;
			stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
