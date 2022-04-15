package com.javawiz.basic.annotation.autowire.byname;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/autowire_byname.xml");
		Person person = ctx.getBean(Person.class);
		System.out.println(person);
		ctx.registerShutdownHook();
		ctx.close();
	}
}
