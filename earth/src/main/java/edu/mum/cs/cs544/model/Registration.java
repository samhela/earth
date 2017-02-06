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

}
