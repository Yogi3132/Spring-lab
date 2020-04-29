package com.labbook.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.labbook.entities.Employee;

@Component
public class EmployeeDaoImpl {

	private Map<Integer, Employee> store = new HashMap<Integer, Employee>();
	
	public EmployeeDaoImpl() {
		store.put(100,new Employee(100,"Aditya",4500));
		store.put(101,new Employee(101,"Ramesh",4000.10));
		store.put(102,new Employee(102,"Ram",42962.70));
	}
	
	public List<Employee> fethcAllEmployees(){
		Collection<Employee> collection = store.values();
		List<Employee> empList = new ArrayList(collection);
		return empList;
	}
	public Employee findEmployee(int id) {
		Employee employee = store.get(id);
		return employee;
	}
	
}
