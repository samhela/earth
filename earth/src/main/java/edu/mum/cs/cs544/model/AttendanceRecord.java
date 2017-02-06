package edu.mum.cs.cs544.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AttendanceRecord {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Student student;
	
	private Date date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Timeslot timeslot;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Location location;
	
}
