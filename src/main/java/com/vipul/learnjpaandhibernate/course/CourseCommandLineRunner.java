package com.vipul.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.vipul.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
//import com.vipul.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.vipul.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
//	insert method is used here for jpa and spring jdbc, we have used save for spring jpa	
//		repository.insert(new Course(1, "Learn Azure JPA", "Coding Ninja"));	
//		repository.insert(new Course(2, "Learn AWS", "Coding Ninja"));
//		repository.insert(new Course(3, "Learn Java", "Coding Ninja"));
//		repository.insert(new Course(4, "Learn Devops", "Coding Ninja"));
		
		repository.save(new Course(1, "Learn Azure JPA", "Coding World"));	
		repository.save(new Course(2, "Learn AWS", "Coding World"));
		repository.save(new Course(3, "Learn Java", "Coding Ninja"));
		repository.save(new Course(4, "Learn Devops", "Coding World"));
		
		System.out.println(repository.findAll());
		
		repository.deleteById(2l);

		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println("Count : "+repository.count());
		System.out.println("Author : "+repository.findByAuthor("Coding World"));
		System.out.println("Name : "+repository.findByName("Learn Azure JPA"));
	}
}
