package com.labbook.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.labbook.entities.Employee;
import com.labbook.entities.SBU;

@Configuration
@ComponentScan("com.labbook.entities")
public class JavaConfig {
	
	@Bean
	public SBU sbu() {
		Employee emp1 = new Employee();
		emp1.setEmpId(12345);
		emp1.setEmpName("Akansha");
		emp1.setSalary(40000.0);
		Employee emp2 = new Employee();
		emp2.setEmpId(15468);
		emp2.setEmpName("Neha");
		emp2.setSalary(64000.0);
		List<Employee> empList= new ArrayList<Employee>();
		empList.add(emp1);
		empList.add(emp2);
		SBU sbuobj = new SBU();
		sbuobj.setSbuCode("PSE-BU");
		sbuobj.setSbuHead("Kiran Rao");
		sbuobj.setSbuName("Rohan");
		sbuobj.setEmpList(empList);
		return sbuobj;
	}
}
