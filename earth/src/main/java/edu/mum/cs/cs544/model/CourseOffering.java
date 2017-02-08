package edu.mum.cs.cs544.model;

import java.util.Date;

import javax.persistence.*;

@NamedQueries({
		@NamedQuery(
				name = "CourseOffering.findCourseOfferingById",
				query = "SELECT co FROM CourseOffering co WHERE co.id = :courseOfferringId"
		),
		@NamedQuery(
				name = "CourseOffering.findCourseOfferingByLocation",
				query = "SELECT co FROM CourseOffering co LEFT JOIN co.location l WHERE l.name = :locationName"
		),
		@NamedQuery(
				name = "CourseOffering.findCourseOfferingByCourseName",
				query = "SELECT co FROM CourseOffering co LEFT JOIN co.course c WHERE c.name = :courseName"
		),
		@NamedQuery(
				name = "CourseOffering.allCourseOfferings",
				query = "FROM CourseOffering"
		)

})
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

	public CourseOffering() {
	}

	public CourseOffering(String courseOfferingId, Date startDate, Date endDate) {
		this.courseOfferingId = courseOfferingId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseOfferingId() {
		return courseOfferingId;
	}

	public void setCourseOfferingId(String courseOfferingId) {
		this.courseOfferingId = courseOfferingId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}

