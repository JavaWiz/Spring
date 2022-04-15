package com.javawiz.basic.xml.autowire.byname;

public class Person {
	private String name;
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
