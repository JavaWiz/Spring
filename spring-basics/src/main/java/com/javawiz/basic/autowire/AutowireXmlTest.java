package com.javawiz.basic.autowire;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireXmlTest {

	public static void main(String[] args) {
		System.out.println("################## Autowire byName ##################");
		AbstractApplicationContext ctx1 = new ClassPathXmlApplicationContext("autowire-xml.xml");
		CustomerService customerServiceByName = (CustomerService) ctx1.getBean("customerServiceByName");
		customerServiceByName.getCustomer();
		ctx1.registerShutdownHook();
		ctx1.close();
		System.out.println("################## Autowire byName End ##############\n");
		System.out.println("################## Autowire byType ##################");
		AbstractApplicationContext ctx2 = new ClassPathXmlApplicationContext("autowire-xml.xml");
		CustomerService customerServiceByType = (CustomerService) ctx2.getBean("customerServiceByType");
		customerServiceByType.getCustomer();
		ctx2.registerShutdownHook();
		ctx2.close();
		System.out.println("################## Autowire byType End ##################\n");
		System.out.println("################## Autowire byConstructor ##################");
		AbstractApplicationContext ctx3 = new ClassPathXmlApplicationContext("autowire-xml.xml");
		CustomerService customerServiceByConstructor = (CustomerService) ctx3.getBean("customerServiceByConstructor");
		customerServiceByConstructor.getCustomer();
		ctx3.registerShutdownHook();
		ctx3.close();
		System.out.println("################## Autowire byConstructor End ##################\n");
	}
}
