package com.labbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labbook.dao.EmployeeDaoImpl;
//import com.labbook.dao.EmployeeDao;
import com.labbook.entities.Employee;
import com.labbook.exception.EmployeeNotFoundException;

@Component
public class EmployeeServiceImpl {
	private EmployeeDaoImpl empdao;

	public EmployeeDaoImpl getEmpdao() {
		return empdao;
	}
	@Autowired
	public void setEmpdao(EmployeeDaoImpl empdao) {
		this.empdao = empdao;
	}
	
	public List<Employee> fetchAllEmployees(){
		return empdao.fethcAllEmployees();
	}
	public Employee findEmployee(int empId) {
		Employee emp = empdao.findEmployee(empId);
		if(emp==null) {
			throw new EmployeeNotFoundException("Not such employee is present with id "+empId);
		}
		return emp;
	}
}
