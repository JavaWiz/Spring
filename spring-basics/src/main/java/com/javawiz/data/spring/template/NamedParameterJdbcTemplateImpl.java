package com.javawiz.data.spring.template;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class NamedParameterJdbcTemplateImpl {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public void init() {
		drop();
		create();
		insert();
	}

	// Drop schema if it exists
	private void drop() {
		template.execute("DROP SCHEMA PUBLIC CASCADE", new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});
	}

	private void create() {
		template.execute(
				"CREATE TABLE EMPLOYEE (id INT NOT NULL, name VARCHAR(50) NOT NULL, deg VARCHAR(20) NOT NULL, PRIMARY KEY (id))",
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
						return ps.executeUpdate();
					}
				});
	}
	
	private void insert() {
	      String SQL = "INSERT INTO Employee (id, name, deg) VALUES (:id, :name, :deg)";
	      Map<String, Object> namedParameters = new HashMap<>();   
	      namedParameters.put("id", 100);   
	      namedParameters.put("name", "Ranjan Sai");
	      namedParameters.put("deg", "Analyst");
	      template.update(SQL, namedParameters);
	}
	
	public void update(String deg, int id) {
		String SQL = "UPDATE Employee SET deg = :deg WHERE id = :id";
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("deg", deg);
		namedParameters.addValue("empid", id);
		template.update(SQL, namedParameters);
		System.out.println("Updated Record with ID = " + id);
	}

	
	/**
	 * Queries with Named Parameters
	 * To get support for named parameters, 
	 * we’ll use the other JDBC template provided by the framework – the NamedParameterJdbcTemplate.
	 * Additionally, this wraps the JbdcTemplate 
	 * and provides an alternative to the traditional syntax using “?” to specify parameters. 
	 * Under the hood, it substitutes the named parameters to JDBC “?” placeholder 
	 * and delegates to the wrapped JbdcTemplate to execute the queries
	 * @return 
	 */
	public String findNameById(int id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(
		    "SELECT NAME FROM EMPLOYEE WHERE ID = :id", namedParameters, String.class);
	}
}
