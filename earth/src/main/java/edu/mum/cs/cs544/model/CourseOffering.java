package edu.mum.cs.cs544.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CourseOffering {
	@Id
	@GeneratedValue
	private int id;

	private String courseOfferingId;

	@ManyToOne(cascade = CascadeType.ALL)
	private Course course;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@ManyToOne(cascade = CascadeType.ALL)
	private Location location;

}
