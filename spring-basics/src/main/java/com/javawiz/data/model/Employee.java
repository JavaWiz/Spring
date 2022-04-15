package com.javawiz.data.model;

public class Employee {
	private int id;
	private String name;
	private String designation;
	public Employee(int id, String name, String designation) {
		this.id = id;
		this.name = name;
		this.designation = designation;
	}
	@Override
	public String toString() {
		return id + " | " + name + " | " + designation;
	}
}
