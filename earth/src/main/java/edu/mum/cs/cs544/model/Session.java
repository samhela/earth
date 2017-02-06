package edu.mum.cs.cs544.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Session {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CourseOffering courseOffering;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Timeslot timeslot;
	
	private Date date;
	
}
