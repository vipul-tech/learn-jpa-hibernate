package com.vipul.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.vipul.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	
//	This annotation is used in place of @Autowired 
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public void deleteById(Long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
}
