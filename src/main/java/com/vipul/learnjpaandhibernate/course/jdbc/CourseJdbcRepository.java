package com.vipul.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vipul.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY = """
			INSERT INTO COURSE(ID,NAME,AUTHOR) VALUES(?, ?, ?);
			""" ;
	
	private static String DELETE_QUERY = """
			DELETE FROM COURSE WHERE ID = ?;
			""";
	
	private static String SELECT_QUERY = """
			SELECT * FROM COURSE WHERE ID = ?;
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, 
				course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(Long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course findById(Long id) {
		return springJdbcTemplate.queryForObject
			(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
