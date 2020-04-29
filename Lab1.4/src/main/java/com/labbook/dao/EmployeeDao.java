package com.labbook.dao;

import java.util.List;

import com.labbook.entities.Employee;

public interface EmployeeDao {
	List<Employee>fetchAllEmployees();
}
