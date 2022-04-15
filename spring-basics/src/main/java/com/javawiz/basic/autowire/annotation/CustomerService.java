package com.javawiz.basic.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CustomerService {
	
	//Autowired annotation on variable/setters is equivalent to autowire = "byType"
	@Autowired
	private CustomerDao customerDao;
	
	public CustomerService() {
		System.out.println("Default constructor is called.");
		System.out.println();
	}
	
	/**
	 * Autowired annotation on Constructor is equivalent to autowire="constructor"
	 * @param customerDao
	 */
	@Autowired
	public CustomerService(@Qualifier("customerDaoForQualifier")CustomerDao customerDao) {
		System.out.println("Constructor with argument called.");
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
