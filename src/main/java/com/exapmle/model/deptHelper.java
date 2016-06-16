package com.exapmle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class deptHelper {
	private String url = "jdbc:mysql://localhost:3306/mysql";
	private String user = "root";
	private String pw = "root";
	public String Create(int DeptId, String DeptName) {
		try (Connection conn = DriverManager.getConnection(url, user, pw);
				Statement stmt = conn.createStatement();) {
			//check duplicate
			String checkSql = "select DeptId from antra.Department where DeptId =" + "'" + DeptId + "'";
			ResultSet rset = stmt.executeQuery(checkSql);
			
			int rowCount = 0;
			while(rset.next()){
				rowCount ++;
			}
			
			if(rowCount != 0){
				return "Duplicate";
			}else{
				String sql = "insert into antra.Department values(" + "'" + DeptId + "', '" + DeptName + "')";
				stmt.executeUpdate(sql);
				return "Succeed";
			}
		}catch(SQLException ex){
			ex.printStackTrace();
			return "Failed";
		}
	}

	public String Update(int DeptId, String DeptName, int CurId) {
		try(
				Connection conn = DriverManager.getConnection(
					url, user, pw);
				Statement stmt = conn.createStatement();
		){
			String sql = "update antra.DepartMent set DeptId=" + DeptId +
					", DeptName='" + DeptName  +
					"' where DeptId=" + CurId; 
			
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
	}

	public void Delete(int DeptId) {
		try (Connection conn = DriverManager.getConnection(url, user, pw);
				Statement stmt = conn.createStatement();) {
			
			String sql = "delete from antra.Department where DeptId=" +DeptId;
			stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
