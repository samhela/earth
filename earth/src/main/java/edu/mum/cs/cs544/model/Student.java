package edu.mum.cs.cs544.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@NamedQueries({
		@NamedQuery(
				name = "Student.findByStudentId",
				query = "SELECT s FROM Student s WHERE s.id = :studentId"
		),
		@NamedQuery(
				name = "Student.finadAllStudent",
				query = "FROM Student"
		)

})
@Entity
public class Student{

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String studentId;
	@NotNull
	private String firstname;
	private String lastname;
	private String barcode;

	@OneToOne
	private User user;

	public Student() {

	}

	public Student(String studentId, String firstname, String lastname, String barcode) {

		this.studentId = studentId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.barcode = barcode;

		/*setUserName(studentId);
		setPassword(studentId);
		UserProfile userProfile = new UserProfile();
		Set<UserProfile> userProfiles = new HashSet<UserProfile>();
		userProfile.setType(UserProfileType.STUDENT.getUserProfileType());
		setUserProfiles(userProfiles);*/



	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}



}
