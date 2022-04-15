package com.javawiz.basic.annotation.autowire.constructor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/autowire_constructor.xml");
		Person person = (Person)ctx.getBean("person");
		System.out.println(person);
		ctx.registerShutdownHook();
		ctx.close();
	}
}
