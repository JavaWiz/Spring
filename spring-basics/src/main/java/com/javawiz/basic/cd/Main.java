package com.javawiz.basic.cd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		CircularDependencyA a = ctx.getBean(CircularDependencyA.class);
		ctx.registerShutdownHook();
		ctx.close();
	}
}
