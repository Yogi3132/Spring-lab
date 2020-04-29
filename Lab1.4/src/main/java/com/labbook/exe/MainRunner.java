package com.labbook.exe;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.labbook.config.JavaConfig;
import com.labbook.entities.Employee;
import com.labbook.service.EmployeeServiceImpl;

public class MainRunner {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Class configurationClass = JavaConfig.class;
		context.register(configurationClass);
		context.refresh();
		EmployeeServiceImpl empimpl = context.getBean(EmployeeServiceImpl.class);
		List<Employee> emplist = empimpl.fetchAllEmployees();
		System.out.println("Enter the Employee Id : ");
		int id= scn.nextInt();
		Employee employee=empimpl.findEmployee(id);
		System.out.println(employee);
	}
}
