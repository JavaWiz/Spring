package com.javawiz.basic.injection;

public class CustomerService {
	
	private CustomerDao customerDao;
	
	public CustomerService() {
		System.out.println("Default Constructor is called.");
	}
	
	public CustomerService(CustomerDao customerDao) {
		System.out.println("Constructor with argument is called.");
		this.customerDao = customerDao;
	}
	
	public void setCustomerDao(CustomerDao customerDao) {
		System.out.println("setter method is called.");
		this.customerDao = customerDao;
	}
	
	public void getCustomer() {
		System.out.println(customerDao.getCustomer());
	}
}
