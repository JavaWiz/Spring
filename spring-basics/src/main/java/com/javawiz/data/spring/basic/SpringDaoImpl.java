package com.javawiz.data.spring.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.javawiz.data.model.Employee;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Repository
public class SpringDaoImpl {
	
	@Autowired
	private DataSource dataSource;
	
	public Employee getEmployee() {
		
		Connection con = null;
		PreparedStatement ps = null;
		Employee employee = null;
		try {
			con = dataSource.getConnection();
			if (con != null) {
				System.out.println("Connection created successfully.");
			} else {
				System.out.println("Problem with creating connection");
			}
			// Drop schema if it exists
			con.prepareStatement("DROP SCHEMA PUBLIC CASCADE").executeUpdate();
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
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
	    HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
	    hikariConfig.setJdbcUrl("jdbc:hsqldb:file:sampledb"); 
	    hikariConfig.setUsername("SA");
	    hikariConfig.setPassword("");

	    hikariConfig.setMaximumPoolSize(5);
	    //hikariConfig.setConnectionTestQuery("SELECT 1");
	    hikariConfig.setPoolName("springHikariCP");

	    hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
	    hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

	    return dataSource;
	}
}
