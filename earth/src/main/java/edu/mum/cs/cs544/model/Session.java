package edu.mum.cs.cs544.model;

import javax.persistence.*;
import java.util.Date;
@NamedQueries({
		@NamedQuery(
				name = "Session.findBySessionId",
				query = "SELECT s FROM Session s WHERE s.id = :sessionId"
		),
		@NamedQuery(
				name = "Session.allSessions",
				query = "FROM Session"
		),
		@NamedQuery(
				name = "Session.findByCourseOfferingId",
				query = "SELECT s FROM Session s LEFT JOIN s.courseOffering co WHERE co.id = :courseOfferingId"
		)

})
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
	
	public Session() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CourseOffering getCourseOffering() {
		return courseOffering;
	}

	public void setCourseOffering(CourseOffering courseOffering) {
		this.courseOffering = courseOffering;
	}

	public Timeslot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
