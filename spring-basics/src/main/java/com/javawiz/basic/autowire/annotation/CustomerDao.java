package com.javawiz.basic.autowire.annotation;

import com.javawiz.model.Customer;

public class CustomerDao {
	
	public Customer getCustomer() {
		return new Customer("Ranjan");
	}
}
