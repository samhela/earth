package edu.mum.cs.cs544.model;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
		@NamedQuery(
				name = "Location._findByLocationId",
				query = "SELECT l FROM Location l WHERE l.id= :locationId"
		),
		@NamedQuery(
				name = "Location._findByLocationName",
				query = "SELECT l FROM Location l WHERE l.name= :locationName"
		),
		@NamedQuery(
				name = "Location.allLocations",
				query = "FROM Location"
		)
})

@Entity
public class Location {
	@Id
	@GeneratedValue
	private int id;

	private String locationId;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	private List<CourseOffering> courseOfferingList;
	
	public Location() {
	}

	public Location(String locationId, String name) {
		this.locationId = locationId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CourseOffering> getCourseOfferingList() {
		return courseOfferingList;
	}

	public void setCourseOfferingList(List<CourseOffering> courseOfferingList) {
		this.courseOfferingList = courseOfferingList;
	}
}
