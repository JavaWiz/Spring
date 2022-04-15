package com.javawiz.basic.autowire.annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx1 = new ClassPathXmlApplicationContext("autowire-annotation.xml");
		CustomerService customerService = (CustomerService) ctx1.getBean("customerService");
		customerService.getCustomer();
		ctx1.registerShutdownHook();
		ctx1.close();
	}

}
