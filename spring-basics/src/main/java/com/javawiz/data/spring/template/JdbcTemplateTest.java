package com.javawiz.data.spring.template;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateTest {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("data/template-config.xml");
		JdbcTemplateImpl dao = context.getBean(JdbcTemplateImpl.class);
		dao.init();
		System.out.println(dao.findById(101));
		System.out.println("Number of Employee: "+dao.count());
		dao.findAll().forEach(System.out::println);
		context.registerShutdownHook();
		context.close();
	}
}
