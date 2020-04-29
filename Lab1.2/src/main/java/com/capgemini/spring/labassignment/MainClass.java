package com.capgemini.spring.labassignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		
		EmployeeModel emp = context.getBean(EmployeeModel.class);
		SBU sbu = context.getBean(SBU.class);
		
		System.out.println(emp);
		emp.showDeatils();
	}
}
