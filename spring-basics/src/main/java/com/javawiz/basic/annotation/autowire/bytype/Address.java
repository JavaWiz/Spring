package com.javawiz.basic.annotation.autowire.bytype;

public class Address {
	private String city;
	private String state;
	private String country;
	
	public Address(){
		System.out.println("Address constructor called");
	}

	public Address(String city, String state, String country) {
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String toString() {
		return city + " " + state + " " + country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		System.out.println("Address city setter called");
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		System.out.println("Address state setter called");
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		System.out.println("Address country setter called");
		this.country = country;
	}
}