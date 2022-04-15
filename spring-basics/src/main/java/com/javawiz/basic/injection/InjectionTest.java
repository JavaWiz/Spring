package com.javawiz.basic.injection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectionTest {
	public static void main(String[] args) {
		AbstractApplicationContext ctx1 = new ClassPathXmlApplicationContext("injection.xml");
		CustomerService customerServiceConstructor = (CustomerService) ctx1.getBean("customerServiceConstructor");
		customerServiceConstructor.getCustomer();
		ctx1.registerShutdownHook();
		ctx1.close();
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("injection.xml");
		CustomerService customerServiceSetter = (CustomerService) ctx.getBean("customerServiceSetter");
		customerServiceSetter.getCustomer();
		ctx.registerShutdownHook();
		ctx.close();
	}
}
