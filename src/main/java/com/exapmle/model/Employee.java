package com.exapmle.model;

public class Employee {
	private int eId;
	private String name;
	private int deptId;
	private int projectId;
	private String department;
	private String project;
	
	public Employee(int eid, String name, int deptid, int projectid, String department, String project){
		this.eId = eid;
		this.name = name;
		this.deptId = deptid;
		this.projectId = projectid;
		this.department = department;
		this.project = project;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEId() {
		return eId;
	}

	public void setEId(int EId) {
		eId = EId;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		name = Name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int DeptId) {
		deptId = DeptId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String Project) {
		project = Project;
	}
	
}
