package edu.mum.cs.cs544.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Timeslot {

	@Id
	@GeneratedValue
	private int id;
	
	private String abbrv;
	private String description;
	
	@Temporal(TemporalType.TIME)
	private Date beginTime;
	
	@Temporal(TemporalType.TIME)
	private Date endTime;
	
}
