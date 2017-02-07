package edu.mum.cs.cs544.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registration {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Student student;

	@ManyToOne
	private CourseOffering courseOffering;
	
	public Registration() {
	}

	
	public Registration(Student student, CourseOffering courseOffering) {
		this.student = student;
		this.courseOffering = courseOffering;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public CourseOffering getCourseOffering() {
		return courseOffering;
	}

	public void setCourseOffering(CourseOffering courseOffering) {
		this.courseOffering = courseOffering;
	}

	
}
