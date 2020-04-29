package com.labbook.exe;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.labbook.config.JavaConfig;
import com.labbook.entities.SBU;

public class MainRunner {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Class configurationClass = JavaConfig.class;
		context.register(configurationClass);
		context.refresh();
		SBU sbu = context.getBean(SBU.class);
		System.out.println(sbu);
	}
}
