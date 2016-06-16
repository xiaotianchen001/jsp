package com.example.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.entity.Department;
import com.example.entity.Employee;

public class DepartmentDAO{
	public void create(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_DB");
		EntityManager entityMgr = factory.createEntityManager();
		Department dept = new Department();
		dept.setId(6);
		dept.setName("Operation");
		Set<Employee> emps = new HashSet<Employee>();
		dept.setEmps(emps);
		entityMgr.getTransaction().begin();
		entityMgr.persist(dept);
		entityMgr.getTransaction().commit();
		entityMgr.close();
		factory.close();
	}
	
	public void findById(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_DB");
		EntityManager entityMgr = factory.createEntityManager();
		entityMgr.getTransaction().begin();
		
		Department result = entityMgr.find(Department.class, (long)1);
		System.out.println(result.getId() + "," + result.getName());
		entityMgr.getTransaction().commit();
		entityMgr.close();
		factory.close();
	}
	
	public void update(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_DB");
		EntityManager entityMgr = factory.createEntityManager();
		entityMgr.getTransaction().begin();
		Department result = entityMgr.find(Department.class, (long)1);
		result.setName("RD Center");
		entityMgr.getTransaction().commit();
		entityMgr.close();
		factory.close();
	}
	
	public void delete(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_DB");
		EntityManager entityMgr = factory.createEntityManager();
		entityMgr.getTransaction().begin();
		Department result = entityMgr.find(Department.class, 1);
		entityMgr.remove(result);
		entityMgr.getTransaction().commit();
		entityMgr.close();
		factory.close();
	}
	
	public static void main(String[] args){
		DepartmentDAO test = new DepartmentDAO();
		test.create();
	}
}
