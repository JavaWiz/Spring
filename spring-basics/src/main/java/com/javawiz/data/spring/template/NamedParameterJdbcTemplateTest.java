package com.javawiz.data.spring.template;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NamedParameterJdbcTemplateTest {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("data/template-config.xml");
		NamedParameterJdbcTemplateImpl dao = context.getBean(NamedParameterJdbcTemplateImpl.class);
		dao.init();
		System.out.println(dao.findNameById(100));
		context.registerShutdownHook();
		context.close();
	}
}
