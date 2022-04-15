package com.javawiz.data.spring.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.javawiz.data.model.Employee;

@Repository
public class JdbcTemplateImpl {
	
	@Autowired
	private DataSource dataSource;
	
	public void init() {
		drop();
		create();
		insert();
	}
		
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

	// Drop schema if it exists
	private void drop() {
		getJdbcTemplate().execute("DROP SCHEMA PUBLIC CASCADE");
	}
	
	private void create() {
		getJdbcTemplate().execute("CREATE TABLE EMPLOYEE (id INT NOT NULL, name VARCHAR(50) NOT NULL, deg VARCHAR(20) NOT NULL, PRIMARY KEY (id))");
	}
	
	private void insert() {
		getJdbcTemplate().execute("INSERT INTO EMPLOYEE VALUES ( 100,'Ranjan Sai', 'Analyst' )");
		getJdbcTemplate().execute("INSERT INTO EMPLOYEE VALUES ( 101,'Jitender Singh', 'Manager' )");
		getJdbcTemplate().execute("INSERT INTO EMPLOYEE VALUES ( 102,'Aishwarya Singh', 'Programmer' )");
		getJdbcTemplate().update( "INSERT INTO EMPLOYEE VALUES (?, ?, ?)", 103, "Sunita Sahu", "Programmer");
	}
	
	public String findById(int id) {
		return getJdbcTemplate().queryForObject("SELECT name FROM EMPLOYEE where id=?",new Object[]{id}, String.class);
	}
	
	public int count() {
		return getJdbcTemplate().queryForObject("SELECT count(*) FROM EMPLOYEE", Integer.class);
	}
	
	public List<Employee> findAll() {
		return getJdbcTemplate().query("SELECT id, name, deg FROM EMPLOYEE", new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet result, int rowNum) throws SQLException {
				Employee employee = new Employee(result.getInt("id"), result.getString("name"), result.getString("deg"));
				return employee;
			}
		});
	}
}
