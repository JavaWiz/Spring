package com.javawiz.data.lagacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javawiz.data.model.Employee;

public class LagacyDaoImpl {
	public Employee getEmployee() {
		Connection con = null;
		PreparedStatement ps = null;
		Employee employee = null;
		try {
			System.out.println("Registering the HSQLDB JDBC driver ...");
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			System.out.println("HSQLDB JDBC driver Registered");
			System.out.println("Creating the connection with HSQLDB ...");
			con = DriverManager.getConnection("jdbc:hsqldb:file:sampledb", "SA", "");
			if (con != null) {
				System.out.println("Connection created successfully.");
			} else {
				System.out.println("Problem with creating connection");
			}
			
			ps = con.prepareStatement("CREATE TABLE EMPLYEE (id INT NOT NULL, name VARCHAR(50) NOT NULL, deg VARCHAR(20) NOT NULL, PRIMARY KEY (id))");
			System.out.println(ps.executeUpdate() + " row created.");
			
			ps = con.prepareStatement("INSERT INTO EMPLYEE VALUES ( 100,'Ranjan Sai', 'Analyst' )");
			int inserted = ps.executeUpdate();
			con.commit();
			System.out.println(inserted + " row inserted.");
			
			ps = con.prepareStatement("SELECT id, name, deg FROM EMPLYEE");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				employee = new Employee(result.getInt("id"), result.getString("name"), result.getString("deg"));
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return employee;
	}
}
