package com.example.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table
//@Table(name = "department", catalog = "jpadb", uniqueConstraints = {})
public class   implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private Set<Employee> emps;
	
	//@generatedValue(strategy=GenerationType.)
	//@Id(generate = GeneratorType.AUTO)
	@Id
	@Column(name = "dept_id", unique = true, nullable = false,
			insertable = true, updatable = true)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "dept_name", unique = true, nullable = false,
			insertable = true, updatable = true, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY,
			mappedBy = "department")
	public Set<Employee> getEmps() {
		return emps;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
}
