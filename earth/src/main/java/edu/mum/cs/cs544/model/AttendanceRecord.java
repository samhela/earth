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
	
	public AttendanceRecord() {
	
	}

	public AttendanceRecord(Student student, Date date, Timeslot timeslot, Location location) {
	
		this.student = student;
		this.date = date;
		this.timeslot = timeslot;
		this.location = location;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timeslot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
