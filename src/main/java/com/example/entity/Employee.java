package com.example.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(query = "Select e from Employee e where e.eid = :id", name = "find employee by id")
// @Table(name = "employee", catalog = "jpadb", uniqueConstraints = {})
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long eid;
	private String name;
	private Department department;
	private List<Project> projects;

	@Id
	@Column(name = "emp_id", unique = true, nullable = false, insertable = true, updatable = true)
	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	@Column(name = "emp_name", unique = true, nullable = false, insertable = true, updatable = true, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id", unique = false, nullable = true, insertable = true, updatable = true)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "emp_proj", catalog = "jpadb", joinColumns = { @JoinColumn(name = "EMP_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "PROJ_ID", nullable = false, updatable = false) })
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + "]";
	}
}
