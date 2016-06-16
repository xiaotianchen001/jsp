package com.exapmle.model;

public class Department {
	private int deptId;
	private String deptName;
	
	Department(int DeptId, String DeptName){
		this.deptId = DeptId;
		this.deptName = DeptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
