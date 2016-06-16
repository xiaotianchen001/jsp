package com.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.*;

import com.example.entity.Department;
import com.example.entity.Employee;

public class EmployeeDAO {
	public void create(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_DB");
		EntityManager entityMgr = factory.createEntityManager();
		Department dept = new Department();
		dept.setId(6);
		dept.setName("Operation");
		Employee e = new Employee();
		e.setEid(3);
		e.setName("Ha");
		e.setDepartment(dept);
		//order caution!!!
		//for dept & emps
		Set<Employee> emps = new HashSet<Employee>();
		emps.add(e);
		dept.setEmps(emps);
		entityMgr.getTransaction().begin();
		entityMgr.persist(e);
		entityMgr.getTransaction().commit();
		entityMgr.close();
		factory.close();
	}
	
	public List<Employee> getEmpsById(long eid){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_DB");
		EntityManager entityMgr = factory.createEntityManager();
		Query query = entityMgr.createNamedQuery("find employee by id");
		query.setParameter("id", eid);
		List<Employee> ret = query.getResultList();
		for(Employee e: ret){
			System.out.println("Employee ID:" + e.getEid());
			System.out.println("Employee Name :" + e.getName());
		}
		return ret;
	}
	
	public static void main(String[] args){
		EmployeeDAO test = new EmployeeDAO();
		List<Employee> ret = test.getEmpsById(3);
		System.out.println(ret.get(0));
	}
}
