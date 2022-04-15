package com.javawiz.data.spring.basic;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javawiz.data.model.Employee;

public class TestSpringBasic {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("data/basic.xml");
		SpringDaoImpl dao = (SpringDaoImpl) context.getBean("springDaoImpl");
		Employee e = dao.getEmployee();
		System.out.println(e);
		context.registerShutdownHook();
		context.close();
	}
}
