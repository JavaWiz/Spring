package com.javawiz.data.lagacy;

import com.javawiz.data.model.Employee;

public class TestJdbcLagacy {
	public static void main(String[] args) {
		LagacyDaoImpl dao = new LagacyDaoImpl();
		Employee e = dao.getEmployee();
		System.out.println(e);
	}
}
