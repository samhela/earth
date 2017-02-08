package edu.mum.cs.cs544.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NamedQueries({
		@NamedQuery(
				name = "Timeslot.timeslotId",
				query = "SELECT t FROM Timeslot t WHERE t.id= :timeslotId"
		),
		@NamedQuery(
				name = "Location.findBySessionId",
				query = "SELECT t FROM Timeslot t LEFT JOIN t.sessions s WHERE s.id= :sessionId"
		),
		@NamedQuery(
				name = "Timeslot.allTimeslot",
				query = "FROM Timeslot"
		)
})
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

	@OneToMany(cascade = CascadeType.ALL)
	private List<Session> sessions;

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

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
}
