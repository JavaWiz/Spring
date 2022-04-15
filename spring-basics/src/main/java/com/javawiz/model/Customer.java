package com.javawiz.model;

import java.util.Random;

public class Customer {
	private long customerId;
	private String name;
	
	public Customer(){}
	public Customer(String name) {
		this.customerId = new Random().nextInt(1000);
		this.name = name;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + "]";
	}
}
