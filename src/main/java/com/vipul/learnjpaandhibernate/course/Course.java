package com.vipul.learnjpaandhibernate.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//for jpa we used @Entity annotation
@Entity
public class Course {
	
	@Id
	private long id;
	
//	this annotation is only required when java bean column's name are different from table column name
//	@Column(name="")  
	private String name;
	
//	@Column(name="")
	private String author;
	
	public Course() {
		
	}

	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

	
}
