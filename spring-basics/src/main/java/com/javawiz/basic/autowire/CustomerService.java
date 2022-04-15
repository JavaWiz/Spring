package com.javawiz.basic.autowire;

public class CustomerService {
	
	private CustomerDao customerDao;
	
	private EmployeeDao employeeDao;
	
	public CustomerService() {
		System.out.println("Default constructor is called.");
		System.out.println();
	}
	
	public CustomerService(CustomerDao customerDao) {
		System.out.println("Autowiring by constructor used");
		this.customerDao = customerDao;
	}
	
	public void setCustomerDao(CustomerDao customerDao) {
		System.out.println("setter method is called");
		this.customerDao = customerDao;
	}
	
	public void getCustomer() {
		System.out.println(customerDao.getCustomer());
	}
}
