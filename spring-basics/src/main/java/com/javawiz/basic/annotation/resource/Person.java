package com.javawiz.basic.annotation.resource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
/*
 * Java supports javax.annotation.Resource annotation using JSR-250 that is applied on component class 
 * and fields or methods of component class. 
 * When @Resource is applied on fields or methods, 
 * the container injects the requested resource. 
 * Spring supports @Resource annotation. 
 * It behaves same as @Autowired annotation of spring. 
 * @Autowired annotation automatically injects the required bean.
 */
public class Person {
	private String name;
	
	@Resource
	@Qualifier("address2")
	private Address address;
	
	public Person(){
		System.out.println("Person constructor called");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Person name setter called");
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		System.out.println("Person address setter called");
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}
}
