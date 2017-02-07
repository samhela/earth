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

	public Timeslot() {
		
	}
	
	public Timeslot(String abbrv, String description, Date beginTime, Date endTime) {
	
		this.abbrv = abbrv;
		this.description = description;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	public String getAbbrv() {
		return abbrv;
	}

	public void setAbbrv(String abbrv) {
		this.abbrv = abbrv;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
}
