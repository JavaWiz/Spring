package com.javawiz.basic.injection;

import com.javawiz.model.Customer;

public class CustomerDao {
	
	public Customer getCustomer() {
		return new Customer("Ranjan");
	}
}
