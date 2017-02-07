package edu.mum.cs.cs544.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="APP_USER")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8370105923630574386L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	//@NotEmpty
	@Column(name="USER_NAME", unique=true, nullable=false)
	private String userName;
	
	//@NotEmpty
	@Column(name="PASSWORD", nullable=false)
	private String password;
		
	//@NotEmpty
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;

	//@NotEmpty
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;

	//@NotEmpty
	@Column(name="EMAIL", nullable=false)
	private String email;

	//@NotEmpty
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "APP_USER_USER_PROFILE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", UserName=" + userName + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}


	
}
